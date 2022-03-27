package org.openvasp.core.model.ivms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.openvasp.core.model.ivms101.*;


import static org.openvasp.core.model.ivms.TestData.getResource;

public class Ivms101Test {
    @Test
    void testGenerateIvms101() {
        IdentityPayload privateInfo = TestData.getIdentityPayload();

        Ivms101 ivms1 = new Ivms101();
        ivms1.setIdentityPayload(privateInfo);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Ivms101 ivms2 = gson.fromJson(getResource("json-test-data/ivms101/ivms101.json"), Ivms101.class);
        String ivmsStr1 = gson.toJson(ivms1);
        String ivmsStr2 = gson.toJson(ivms2);

        Assertions.assertEquals(ivmsStr1, ivmsStr2);
    }
}