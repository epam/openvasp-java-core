package org.openvasp.core.model.vasp;

import com.google.gson.annotations.SerializedName;
import org.openvasp.core.model.ivms101.IdentityPayload;

public class FundsRequest {
    public static final String SERIALIZED_NAME_IVMS101 = "IVMS101";
    @SerializedName(SERIALIZED_NAME_IVMS101)
    private IdentityPayload identityPayload;

    public static final String SERIALIZED_NAME_LNURL = "lnurl";
    @SerializedName(SERIALIZED_NAME_LNURL)
    private String lnurl;

    public IdentityPayload getIdentityPayload() {
        return identityPayload;
    }

    public void setIdentityPayload(IdentityPayload identityPayload) {
        this.identityPayload = identityPayload;
    }

    public String getLnurl() {
        return lnurl;
    }

    public void setLnurl(String lnurl) {
        this.lnurl = lnurl;
    }
}
