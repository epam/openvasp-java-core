package org.openvasp.core.rest;

import org.openvasp.core.lnurl.Lnurl;
import org.openvasp.core.model.ivms101.Beneficiary;
import org.openvasp.core.model.ivms101.IdentityPayload;
import org.openvasp.core.model.vasp.FundsRequest;
import org.openvasp.core.model.vasp.VaspAccount;
import org.openvasp.core.service.VaspService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RequestMapping(path = "/api/beneficiary")
@RestController
public class BeneficiaryController {
    @Autowired
    VaspService vaspService;

    @PostMapping("/requestFunds")
    public FundsRequest requestFunds(String login) {
        return vaspService.requestFunds(login);
    }

    @GetMapping("/transferConfirmation")
    public String transferConfirmation(String q) {
        return "{\"version\": \"2.1.0\"}";
    }

}
