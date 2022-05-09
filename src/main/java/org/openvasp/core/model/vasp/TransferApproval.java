package org.openvasp.core.model.vasp;

import com.google.gson.annotations.SerializedName;

public class TransferApproval {
    public static final String SERIALIZED_NAME_APPROVED = "approved";
    @SerializedName(SERIALIZED_NAME_APPROVED)
    private String approved;

    public static final String SERIALIZED_NAME_CALLBACK = "callback";
    @SerializedName(SERIALIZED_NAME_CALLBACK)
    private String callback;

    public String getApproved() {
        return approved;
    }

    public void setApproved(String approved) {
        this.approved = approved;
    }

    public String getCallback() {
        return callback;
    }

    public void setCallback(String callback) {
        this.callback = callback;
    }
}
