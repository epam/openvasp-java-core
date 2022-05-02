package org.openvasp.core.service;

import org.openvasp.core.model.vasp.VaspAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import javax.persistence.EntityManager;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class BaseService {
    public static String API_VERSION = "api";
    public static String API_PROTOCOL = "http";
    @Autowired
    Environment environment;

    EntityManager entityManager;

    public BaseService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public String getBaseApiUrl() {
        try {
            String host = InetAddress.getLocalHost().getHostName();
            String port = environment.getProperty("local.server.port");
            return String.format("%s://%s:%s/%s", API_PROTOCOL, host, port, API_VERSION);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }

    }

    public VaspAccount getVaspAccount(String login) {
        VaspAccount account = entityManager.createQuery(
                String.format("select a from VaspAccount a where a.login = '%s'", login),
                VaspAccount.class).getSingleResult();
        return account;
    }
}
