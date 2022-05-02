package org.openvasp.core.service;

import org.openvasp.core.lnurl.Lnurl;
import org.openvasp.core.model.ivms101.Beneficiary;
import org.openvasp.core.model.ivms101.IdentityPayload;
import org.openvasp.core.model.vasp.*;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Service
public class VaspService extends BaseService {

    public VaspService(EntityManager entityManager) {
        super(entityManager);
    }

    private void persistAccount(VaspAccount account) {
        entityManager.persist(account);
        entityManager.flush();
    }

    @Transactional
    public long addVaspAccount(VaspAccount account){
        try {
            VaspAccount vaspAccount = getVaspAccount(account.getLogin());
        } catch (NoResultException e) {
            account.setAccountNumber(Lnurl.getRandomHexString(34));
            persistAccount(account);
            return account.getId();
        }
        throw new RuntimeException("Account " + account.getLogin() + " already exists!");
    }

    @Transactional
    public VaspAccount updateAssetAddress(String login, String assetType, String assetAddress) {
        VaspAccount account = getVaspAccount(login);
        account.setAssetAddress(assetType, assetAddress);
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
        Lnurl lnurl = Lnurl.generateNewUrl(String.format("%s/lnurl", getBaseApiUrl()));
        VaspAccount account = getVaspAccount(login);
        account.setLnurl(lnurl);
        persistAccount(account);
        Beneficiary beneficiary = new Beneficiary();
        beneficiary.addBeneficiaryPersonsItem(account.getPerson());
        beneficiary.addAccountNumbersItem(account.getAccountNumber());
        IdentityPayload identityPayload = new IdentityPayload();
        identityPayload.setBeneficiary(beneficiary);
        FundsRequest fundsRequest = new FundsRequest();
        fundsRequest.setLnurl(lnurl.getEncoded());
        fundsRequest.setIdentityPayload(identityPayload);
        return fundsRequest;
    }

    public String getBaseApiUrl() {
        try {
            String host = InetAddress.getLocalHost().getHostName();
            String port = environment.getProperty("local.server.port");
            return String.format("%s://%s:%s/%s", API_PROTOCOL, host, port, API_VERSION);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }

    }

    public LnurlResponse getLnurlResponse(String q, String tag) {
        LnurlResponse response = new LnurlResponse();
        response.setTag(tag);
        VaspAccount account = entityManager.createQuery(
                String.format("select a from VaspAccount a where a.lnurlQuery = '%s'", q),
                VaspAccount.class).getSingleResult();
        String assetType = account.getAssetsAddresses().keySet().iterator().next();
        response.setAddress(account.getAssetAddress(assetType));
        response.setAsset(assetType);
        return response;
    }
}
