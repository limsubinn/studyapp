package com.example.orion.model.diary;

import com.google.gson.annotations.SerializedName;

public class CreateDiaryResponse {
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
