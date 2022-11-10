package com.example.dinostudy.model;

import com.google.gson.annotations.SerializedName;

public class EditWatchResponse {
    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
