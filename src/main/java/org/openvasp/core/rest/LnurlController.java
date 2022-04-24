package org.openvasp.core.rest;

import org.openvasp.core.model.vasp.LnurlResponse;
import org.openvasp.core.service.VaspService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "/api")
@RestController
public class LnurlController {
    @Autowired
    VaspService vaspService;

    @GetMapping("/lnurl")
    public LnurlResponse lnurl(String q, String tag) {
        return vaspService.getLnurlResponse(q, tag);
    }
}
