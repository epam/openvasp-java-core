package org.openvasp.core.model.ivms;

import org.junit.jupiter.api.Test;
import org.openvasp.core.model.ivms101.IdentityPayload;
import org.openvasp.core.model.lnurl.LnurlBody;
import org.openvasp.core.model.lnurl.Slip0044;

public class LnurlBodyTest {
    @Test
    public void testLnurlBody() {
        IdentityPayload privateInfo = TestData.getIdentityPayload();
        LnurlBody body = new LnurlBody();
        body.setIdentityPayload(privateInfo);
        LnurlBody.Asset asset = new LnurlBody.Asset();
        asset.setSlip0044(Slip0044.ETH);
        body.setAsset(asset);
        body.setAmount(1.0);
        body.setCallback("https://originator.com/inquiryResolution?q=4585839457");
    }
}
