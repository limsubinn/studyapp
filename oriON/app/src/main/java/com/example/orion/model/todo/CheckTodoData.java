package com.example.orion.model.todo;

import com.google.gson.annotations.SerializedName;

public class CheckTodoData {
    @SerializedName("username")
    private String username;

    @SerializedName("date")
    private String date;

    public CheckTodoData(String username, String date) {
        this.username = username;
        this.date = date;
    }
}