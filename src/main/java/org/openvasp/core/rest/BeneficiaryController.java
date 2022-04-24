package org.openvasp.core.rest;

import org.openvasp.core.model.vasp.FundsRequest;
import org.openvasp.core.service.VaspService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "/api/beneficiary")
@RestController
public class BeneficiaryController {
    @Autowired
    VaspService vaspService;

    @PostMapping("/requestFunds")
    public FundsRequest requestFunds(String login) {
        return vaspService.requestFunds(login);
    }

}
