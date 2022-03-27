package org.openvasp.core.model.lnurl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import org.openvasp.core.model.ivms101.*;

/**
 * Model for LNURL body model.
 * {
 *     "IVMS101": ...,
 *     "asset": {
 *         "slip0044": [asset identifier as per SLIP-0044],
 *     },
 *     "amount": [amount in lowest denomination of asset],
 *     "callback": "https://originator.com/inquiryResolution?q=4585839457"
 * }
 */
public class LnurlBody {
    public static final String SERIALIZED_NAME_IVMS101 = "IVMS101";
    @SerializedName(SERIALIZED_NAME_IVMS101)
    private IdentityPayload identityPayload;

    public static final String SERIALIZED_NAME_ASSET = "asset";
    @SerializedName(SERIALIZED_NAME_ASSET)
    private Asset asset;

    public static final String SERIALIZED_NAME_AMOUNT = "amount";
    @SerializedName(SERIALIZED_NAME_AMOUNT)
    private double amount;

    public static final String SERIALIZED_NAME_CALLBACK = "callback";
    @SerializedName(SERIALIZED_NAME_CALLBACK)
    private String callback;

    public static class Asset {
        public static final String SERIALIZED_NAME_SLIP0044 = "slip0044";
        @SerializedName(SERIALIZED_NAME_SLIP0044)
        private Slip0044 slip0044;

        public Slip0044 getSlip0044() {
            return slip0044;
        }

        public void setSlip0044(Slip0044 slip0044) {
            this.slip0044 = slip0044;
        }
    }

    public IdentityPayload getIdentityPayload() {
        return identityPayload;
    }

    public void setIdentityPayload(IdentityPayload identityPayload) {
        this.identityPayload = identityPayload;
    }

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCallback() {
        return callback;
    }

    public void setCallback(String callback) {
        this.callback = callback;
    }

}
