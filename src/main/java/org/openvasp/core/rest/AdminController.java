package org.openvasp.core.rest;

import org.openvasp.core.model.vasp.VaspAccount;
import org.openvasp.core.service.VaspService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "/api/admin")
@RestController
public class AdminController {
    @Autowired
    private VaspService vaspService;

    @PostMapping(path = "/addVaspAccount")
    public VaspAccount addVaspAccount(@RequestBody VaspAccount account) {
        vaspService.addVaspAccount(account);
        return account;
    }

    @PostMapping(path = "/updateVaspAccount")
    public VaspAccount updateVaspAccountNumber(String login, String accountNumber) {
        return vaspService.updateAccountNumber(login, accountNumber);
    }

    @GetMapping(path = "/getVaspAccount")
    public VaspAccount getVaspAccount(String login) {
        return vaspService.getVaspAccount(login);
    }
}
