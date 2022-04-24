package org.openvasp.core.service;

import org.openvasp.core.lnurl.Lnurl;
import org.openvasp.core.model.ivms101.Beneficiary;
import org.openvasp.core.model.ivms101.IdentityPayload;
import org.openvasp.core.model.ivms101.Originator;
import org.openvasp.core.model.vasp.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Service
public class VaspService {
    public static String API_VERSION = "api";
    public static String API_PROTOCOL = "http";

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
        String lnurl = Lnurl.generateNewUrl(String.format("%s/lnurl", getBaseApiUrl()));
        int i = lnurl.indexOf("q=");
        String q = lnurl.substring(i + 2, i + 14);
        String encodedUrl = Lnurl.encodeUrl(lnurl);
        VaspAccount account = getVaspAccount(login);
        account.setLnurl(encodedUrl);
        account.setLnurlQuery(q);
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
    }

    public FundsRequestConfirmation confirmFundsRequest(FundsRequest fundsRequest,
                                                        String login, String type, double amount) {
        try{
            VaspAccount account = getVaspAccount(login);
            Originator originator = new Originator();
            originator.addOriginatorPersonsItem(account.getPerson());
            originator.addAccountNumbersItem(account.getAccountNumber());
            IdentityPayload identityPayload = fundsRequest.getIdentityPayload();
            identityPayload.setOriginator(originator);
            FundsRequestConfirmation confirmation = new FundsRequestConfirmation();
            confirmation.setIdentityPayload(identityPayload);
            confirmation.setAmount(amount);
            FundsRequestConfirmation.Asset asset = new FundsRequestConfirmation.Asset();
            asset.setSlip0044(Slip0044.valueOf(type));
            confirmation.setAsset(asset);
            String baseUrl = getBaseApiUrl();
            confirmation.setCallback(String.format("%s/originator/inquiryResolution?q=%s",
                    baseUrl, Lnurl.getRandomHexString(12)));
            return confirmation;
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
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
        String assetType = account.getAddresses().keySet().iterator().next();
        response.setAddress(account.getAddress(assetType));
        response.setAsset(assetType);
        return response;
    }
}
