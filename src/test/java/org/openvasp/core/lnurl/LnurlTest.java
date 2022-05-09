package org.openvasp.core.lnurl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LnurlTest {
    @Test
    void generateLnurl() {
        Lnurl lnurl = Lnurl.generateNewUrl("https://beneficiary.com");
        String encodedUrl = lnurl.getEncoded();
        String decodedUrl = Lnurl.decodeUrl(encodedUrl);
        Assertions.assertEquals(lnurl, decodedUrl);
    }
}
