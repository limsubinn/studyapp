package com.example.orion.model.diary;

import com.google.gson.annotations.SerializedName;

public class CreateDiaryData {
    @SerializedName("username")
    private String username;

    @SerializedName("date")
    private String date;

    @SerializedName("good")
    private String good;

    @SerializedName("bad")
    private String bad;

    public CreateDiaryData(String username, String date, String good, String bad) {
        this.username = username;
        this.date = date;
        this.good = good;
        this.bad = bad;
    }
}