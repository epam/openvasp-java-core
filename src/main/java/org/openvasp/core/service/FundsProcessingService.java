package org.openvasp.core.service;

import com.google.gson.Gson;
import org.openvasp.core.lnurl.Lnurl;
import org.openvasp.core.model.ivms101.Beneficiary;
import org.openvasp.core.model.ivms101.IdentityPayload;
import org.openvasp.core.model.ivms101.Originator;
import org.openvasp.core.model.ivms101.Person;
import org.openvasp.core.model.vasp.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.nio.charset.StandardCharsets;

@Service
public class FundsProcessingService extends BaseService {

    @Autowired
    KnowYourCustomer knowYourCustomer;

    public FundsProcessingService(EntityManager entityManager) {
        super(entityManager);
    }

    public void checkBeneficiary(FundsRequest fundsRequest) {
        Person beneficiary = fundsRequest.getIdentityPayload().getBeneficiary().getBeneficiaryPersons().get(0);
        if (!knowYourCustomer.checkCustomer(beneficiary)) {
            throw new RuntimeException("Bad beneficiary: " + beneficiary);
        }
    }

    public void checkOriginator(FundsRequestConfirmation confirmation) {
        Person originator = confirmation.getIdentityPayload().getOriginator().getOriginatorPersons().get(0);
        if (!knowYourCustomer.checkCustomer(originator)) {
            throw new RuntimeException("Bad originator: " + originator);
        }
    }

    private FundsRequestConfirmation getFundsRequestConfirmation(VaspAccount account, FundsRequest fundsRequest,
                                                                double amount, String assetType) {
        Originator originator = new Originator();
        originator.addOriginatorPersonsItem(account.getPerson());
        originator.addAccountNumbersItem(account.getAccountNumber());
        IdentityPayload identityPayload = fundsRequest.getIdentityPayload();
        identityPayload.setOriginator(originator);
        FundsRequestConfirmation confirmation = new FundsRequestConfirmation();
        confirmation.setIdentityPayload(identityPayload);
        confirmation.setAmount(amount);
        FundsRequestConfirmation.Asset asset = new FundsRequestConfirmation.Asset();
        asset.setSlip0044(Slip0044.valueOf(assetType));
        confirmation.setAsset(asset);
        String baseUrl = getBaseApiUrl();
        confirmation.setCallback(String.format("%s/originator/inquiryResolution?q=%s",
                baseUrl, Lnurl.getRandomHexString(12)));
        return confirmation;
    }
    @Transactional
    public Response sendFunds(FundsRequest fundsRequest, String login, String assetType, double amount) {
        checkBeneficiary(fundsRequest);
        VaspAccount account = getVaspAccount(login);
        FundsRequestConfirmation confirmation = getFundsRequestConfirmation(
                account, fundsRequest, amount, assetType);
        String lnurl = Lnurl.decodeUrl(fundsRequest.getLnurl());
        Gson gson = new Gson();
        String payload = gson.toJson(confirmation);
        postRequest(payload, lnurl);
        return new Response();
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

    public LnurlResponse getLnurlResponse(String q, String tag) {
        LnurlResponse response = new LnurlResponse();
        response.setTag(tag);
        VaspAccount account = entityManager.createQuery(
                String.format("select a from VaspAccount a where a.lnurl.secret = '%s'", q),
                VaspAccount.class).getSingleResult();
        String assetType = account.getAssetsAddresses().keySet().iterator().next();
        response.setAddress(account.getAssetAddress(assetType));
        response.setAsset(assetType);
        return response;
    }

    public Response approveTransfer(FundsRequestConfirmation confirmation) {
        checkOriginator(confirmation);
        VaspAccount vaspAccount = getVaspAccount(
                confirmation.getIdentityPayload().getBeneficiary().getAccountNumbers().get(0));
        TransferApproval approval = new TransferApproval();
        approval.setApproved(vaspAccount.getAssetAddress(confirmation.getAsset().getSlip0044().toString()));
        approval.setCallback(String.format("%s/beneficiary/transferConfirmation?q=%s",
                getBaseApiUrl(), Lnurl.getRandomHexString(10)));
        Gson gson = new Gson();
        String payload = gson.toJson(confirmation);
        postRequest(payload, confirmation.getCallback());
        Response response = new Response();
        return response;
    }

    public Response inquiryResolution(@RequestBody TransferConfirmation transferConfirmation, String q) {
        knowYourCustomer.checkAddress(transferConfirmation.getPaymentAddress());
        TransactionConfirmation confirmation = new TransactionConfirmation();
        confirmation.setTxid(Lnurl.getRandomHexString(32));
        Gson gson = new Gson();
        String payload = gson.toJson(confirmation);
        postRequest(payload, transferConfirmation.getCallback());
        Response response = new Response();
        return new Response();
    }

    public Response transferConfirmation(TransactionConfirmation transactionConfirmation) {
        Response response = new Response();
        return new Response();
    }
}
