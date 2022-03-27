package org.openvasp.core.rest;

import org.openvasp.core.lnurl.Lnurl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RequestMapping(path = "/api/beneficiary")
@RestController
public class BeneficiaryController {
    @Autowired
    Environment environment;

    @GetMapping("/requestFunds")
    public String requestFunds() {
        try {
            String hostname = InetAddress.getLocalHost().getHostName();
            String port = environment.getProperty("local.server.port");
            String lnurl = Lnurl.generateNewUrl(hostname, port);
            String encodedUrl = Lnurl.encodeUrl(lnurl);
            return encodedUrl;
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/transferConfirmation")
    public String transferConfirmation(String q) {
        return "{\"version\": \"2.1.0\"}";
    }

}
