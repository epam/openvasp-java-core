package org.openvasp.core.user;

import org.openvasp.core.lnurl.Lnurl;
import org.openvasp.core.model.ivms101.Beneficiary;
import org.openvasp.core.model.lnurl.Slip0044;

public class ReceivingUser {
    private Beneficiary beneficiary;

    public String requestFunds(Slip0044 assetType, double amount) {
        String lnurl = Lnurl.generateNewUrl("localhost", "8080");
        String encodedUrl = Lnurl.encodeUrl(lnurl);
        return encodedUrl;
    }
}
