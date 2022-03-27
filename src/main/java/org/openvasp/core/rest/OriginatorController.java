package org.openvasp.core.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "/api/originator")
@RestController
public class OriginatorController {
    @GetMapping("/inquiryResolution")
    public String inquiryResolution(String q) {
        return "{\"version\": \"2.1.0\"}";
    }

}
