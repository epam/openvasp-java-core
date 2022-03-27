package org.openvasp.core.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "/api")
@RestController
public class LnurlController {
    @GetMapping("/lnurl")
    public String lnurl(String q, String tag) {
        return "{\"version\": \"2.1.0\"}";
    }
}
