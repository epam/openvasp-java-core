package org.openvasp.core.service;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.openvasp.core.model.vasp.VaspAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.io.OutputStream;
import java.net.*;
import java.nio.charset.StandardCharsets;

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

    public VaspAccount getVaspAccount(String accountId) {
        VaspAccount account = entityManager.createQuery(
                String.format("select a from VaspAccount a where a.login = '%s' or a.accountNumber = '%s'",
                        accountId, accountId),
                VaspAccount.class).getSingleResult();
        return account;
    }

    void postRequest(String payload, String strUrl) {
        try {
            try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
                HttpPost request = new HttpPost(strUrl);
                request.addHeader("content-type", "application/json");
                request.setEntity(new StringEntity(payload));
                CloseableHttpResponse response = httpClient.execute(request);
                System.out.println(EntityUtils.toString(response.getEntity(), "UTF-8"));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    void persistAccount(VaspAccount account) {
        entityManager.persist(account);
        entityManager.flush();
    }
}
