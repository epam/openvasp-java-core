package org.openvasp.core.model.vasp;

import com.google.gson.annotations.SerializedName;

public class Response {
    public static final String SERIALIZED_NAME_VERSION = "version";
    @SerializedName(SERIALIZED_NAME_VERSION)
    private final String version = "2.1.0";
}
