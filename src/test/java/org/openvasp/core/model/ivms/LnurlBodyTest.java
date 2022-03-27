package org.openvasp.core.model.ivms;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openvasp.core.model.ivms101.IdentityPayload;
import org.openvasp.core.model.lnurl.LnurlBody;
import org.openvasp.core.model.lnurl.Slip0044;

import static org.openvasp.core.model.ivms.TestData.getResource;

public class LnurlBodyTest {
    @Test
    public void testLnurlBody() {
        IdentityPayload privateInfo = TestData.getIdentityPayload();
        LnurlBody body1 = new LnurlBody();
        body1.setIdentityPayload(privateInfo);
        LnurlBody.Asset asset = new LnurlBody.Asset();
        asset.setSlip0044(Slip0044.ETH);
        body1.setAsset(asset);
        body1.setAmount(1.0);
        body1.setCallback("https://originator.com/inquiryResolution?q=1234567890");

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        LnurlBody body2 = gson.fromJson(getResource("json-test-data/ivms101/lnurl-body.json"), LnurlBody.class);
        String bodyStr1 = gson.toJson(body1);
        String bodyStr2 = gson.toJson(body2);

        Assertions.assertEquals(bodyStr1, bodyStr2);
    }
}
