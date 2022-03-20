package org.openvasp.core.lnurl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ServerTest {
    @Test
    void generateLnurl() {
        Server server = new Server("beneficiary.com");
        String lnurl = server.generateNewUrl();
        String encodedUrl = server.encodeUrl(lnurl);
        String decodedUrl = server.decodeUrl(encodedUrl);
        Assertions.assertEquals(lnurl, decodedUrl);
    }
}
