package org.openvasp.core.rest;

import org.openvasp.core.model.vasp.FundsRequest;
import org.openvasp.core.model.vasp.Response;
import org.openvasp.core.model.vasp.TransactionConfirmation;
import org.openvasp.core.service.FundsProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "/api/beneficiary")
@RestController
public class BeneficiaryController {
    @Autowired
    FundsProcessingService fundsProcessingService;

    @PostMapping("/requestFunds")
    public FundsRequest requestFunds(String login) {
        return fundsProcessingService.requestFunds(login);
    }

    @PostMapping("/transferConfirmation")
    public Response transferConfirmation(@RequestBody TransactionConfirmation transactionConfirmation) {
        return fundsProcessingService.transferConfirmation(transactionConfirmation);
    }

}
