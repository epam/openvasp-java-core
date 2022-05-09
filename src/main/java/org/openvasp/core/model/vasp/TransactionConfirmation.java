package org.openvasp.core.model.vasp;

import com.google.gson.annotations.SerializedName;

public class TransactionConfirmation {
    public static final String SERIALIZED_NAME_TXID = "txid";
    @SerializedName(SERIALIZED_NAME_TXID)
    private String txid;

    public String getTxid() {
        return txid;
    }

    public void setTxid(String txid) {
        this.txid = txid;
    }
}
