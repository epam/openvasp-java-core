package org.openvasp.core.service;

import org.openvasp.core.lnurl.Lnurl;
import org.openvasp.core.model.ivms101.IdentityPayload;
import org.openvasp.core.model.ivms101.Originator;
import org.openvasp.core.model.ivms101.Person;
import org.openvasp.core.model.vasp.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

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

    public FundsRequestConfirmation getFundsRequestConfirmation(VaspAccount account, FundsRequest fundsRequest,
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

        return new Response();
    }

}
