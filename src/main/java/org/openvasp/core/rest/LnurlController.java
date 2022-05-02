package org.openvasp.core.rest;

import org.openvasp.core.model.vasp.FundsRequestConfirmation;
import org.openvasp.core.model.vasp.LnurlResponse;
import org.openvasp.core.model.vasp.Response;
import org.openvasp.core.service.VaspService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "/api")
@RestController
public class LnurlController {
    @Autowired
    VaspService vaspService;

    @GetMapping("/lnurl")
    public Response lnurl(String q, String tag) {
        return vaspService.getLnurlResponse(q, tag);
    }

    @PostMapping("/lnurl")
    public Response lnurl(@RequestBody FundsRequestConfirmation confirmation) {
        Response response = new Response();
        return response;
    }
}
