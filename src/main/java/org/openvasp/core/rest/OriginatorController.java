package org.openvasp.core.rest;

import org.openvasp.core.lnurl.Lnurl;
import org.openvasp.core.model.vasp.*;
import org.openvasp.core.service.FundsProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "/api/originator")
@RestController
public class OriginatorController {
    @Autowired
    FundsProcessingService fundsProcessingService;

    @PostMapping("/sendFunds")
    public Response sendFunds(@RequestBody FundsRequest fundsRequest, String login, String assetType, double amount) {
        return fundsProcessingService.sendFunds(fundsRequest, login,assetType, amount);
    }

    @PostMapping("/inquiryResolution")
    public Response inquiryResolution(@RequestBody TransferConfirmation transferConfirmation, String q) {
        return fundsProcessingService.inquiryResolution(transferConfirmation, q);
    }

}
