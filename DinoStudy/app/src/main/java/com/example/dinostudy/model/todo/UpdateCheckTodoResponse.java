package com.example.dinostudy.model.todo;

import com.google.gson.annotations.SerializedName;

public class UpdateCheckTodoResponse {
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