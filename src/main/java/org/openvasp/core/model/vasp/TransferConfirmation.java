package org.openvasp.core.model.vasp;

import com.google.gson.annotations.SerializedName;

public class TransferConfirmation {
    public static final String SERIALIZED_NAME_PAYMENT_ADDRESS = "paymentAddress";
    @SerializedName(SERIALIZED_NAME_PAYMENT_ADDRESS)
    private String paymentAddress;

    public static final String SERIALIZED_NAME_CALLBACK = "callback";
    @SerializedName(SERIALIZED_NAME_CALLBACK)
    private String callback;

    public String getPaymentAddress() {
        return paymentAddress;
    }

    public void setPaymentAddress(String paymentAddress) {
        this.paymentAddress = paymentAddress;
    }

    public String getCallback() {
        return callback;
    }

    public void setCallback(String callback) {
        this.callback = callback;
    }
}
