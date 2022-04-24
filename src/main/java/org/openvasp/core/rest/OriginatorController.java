package org.openvasp.core.rest;

import org.openvasp.core.lnurl.Lnurl;
import org.openvasp.core.model.vasp.FundsRequestConfirmation;
import org.openvasp.core.model.vasp.FundsRequest;
import org.openvasp.core.model.vasp.TransactionConfirmation;
import org.openvasp.core.model.vasp.TransferConfirmation;
import org.openvasp.core.service.VaspService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "/api/originator")
@RestController
public class OriginatorController {
    @Autowired
    VaspService vaspService;

    @PostMapping("/confirmFundsRequest")
    public FundsRequestConfirmation confirmFundsRequest(@RequestBody FundsRequest fundsRequest,
                                                        String login, String type, double amount) {
        return vaspService.confirmFundsRequest(fundsRequest, login, type, amount);
    }

    @PostMapping("/inquiryResolution")
    public TransactionConfirmation inquiryResolution(@RequestBody TransferConfirmation transferConfirmation, String q) {
        TransactionConfirmation confirmation = new TransactionConfirmation();
        confirmation.setTxid(Lnurl.getRandomHexString(32));
        return confirmation;
    }

}
