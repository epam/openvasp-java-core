package org.openvasp.core.model.ivms101;

import com.google.gson.annotations.SerializedName;

public class Ivms101 {
    public static final String SERIALIZED_NAME_IVMS101 = "IVMS101";
    @SerializedName(SERIALIZED_NAME_IVMS101)
    private IdentityPayload identityPayload;


    public IdentityPayload getIdentityPayload() {
        return identityPayload;
    }

    public void setIdentityPayload(IdentityPayload identityPayload) {
        this.identityPayload = identityPayload;
    }
}
