package org.openvasp.core.service;

import org.openvasp.core.lnurl.Bech32;
import org.openvasp.core.lnurl.Lnurl;
import org.openvasp.core.model.ivms101.Beneficiary;
import org.openvasp.core.model.ivms101.IdentityPayload;
import org.openvasp.core.model.ivms101.Originator;
import org.openvasp.core.model.lnurl.LnurlBody;
import org.openvasp.core.model.lnurl.Slip0044;
import org.openvasp.core.model.vasp.FundsRequest;
import org.openvasp.core.model.vasp.VaspAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

@Service
public class VaspService {
    @Autowired
    Environment environment;

    EntityManager entityManager;

    public VaspService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    private void persistAccount(VaspAccount account) {
        entityManager.persist(account);
        entityManager.flush();
    }

    @Transactional
    public long saveAccount(VaspAccount account){
        persistAccount(account);
        return account.getId();
    }

    @Transactional
    public VaspAccount updateAccountNumber(String login, String accountNumber) {
        VaspAccount account = getVaspAccount(login);
        account.setAccountNumber(accountNumber);
        persistAccount(account);
        return account;
    }

    public VaspAccount getVaspAccount(String login) {
        VaspAccount account = entityManager.createQuery(
                String.format("select a from VaspAccount a where a.login = '%s'", login),
                VaspAccount.class).getSingleResult();
        return account;
    }

    @Transactional
    public FundsRequest requestFunds(String login) {
        try {
            String hostname = InetAddress.getLocalHost().getHostName();
            String port = environment.getProperty("local.server.port");
            String lnurl = Lnurl.generateNewUrl(hostname, port);
            String encodedUrl = Lnurl.encodeUrl(lnurl);
            VaspAccount account = getVaspAccount(login);
            account.setLnurl(encodedUrl);
            persistAccount(account);
            Beneficiary beneficiary = new Beneficiary();
            beneficiary.addBeneficiaryPersonsItem(account.getPerson());
            beneficiary.addAccountNumbersItem(account.getAccountNumber());
            IdentityPayload identityPayload = new IdentityPayload();
            identityPayload.setBeneficiary(beneficiary);
            FundsRequest fundsRequest = new FundsRequest();
            fundsRequest.setLnurl(encodedUrl);
            fundsRequest.setIdentityPayload(identityPayload);
            return fundsRequest;
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

    public LnurlBody confirmFundsRequest(FundsRequest fundsRequest,
                                         String login, String type, double amount) {
        try{
            String hostname = InetAddress.getLocalHost().getHostName();
            String port = environment.getProperty("local.server.port");
            VaspAccount account = getVaspAccount(login);
            Originator originator = new Originator();
            originator.addOriginatorPersonsItem(account.getPerson());
            originator.addAccountNumbersItem(account.getAccountNumber());
            IdentityPayload identityPayload = fundsRequest.getIdentityPayload();
            identityPayload.setOriginator(originator);
            LnurlBody lnurlBody = new LnurlBody();
            lnurlBody.setIdentityPayload(identityPayload);
            lnurlBody.setAmount(amount);
            LnurlBody.Asset asset = new LnurlBody.Asset();
            asset.setSlip0044(Slip0044.ETH);
            lnurlBody.setAsset(asset);
            lnurlBody.setCallback(String.format("http://%s:%s/api/originator/inquiryResolution?q=%s",
                    hostname, port, Lnurl.getRandomHexString(12)));
            return lnurlBody;
        } catch (UnknownHostException | IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
    }
}
