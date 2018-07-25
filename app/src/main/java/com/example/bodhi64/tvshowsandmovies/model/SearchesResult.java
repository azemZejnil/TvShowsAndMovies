package com.example.bodhi64.tvshowsandmovies.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.squareup.moshi.Json;

import java.util.List;

public class SearchesResult
{
    @Json(name = "title")
    public String title;

    @Json(name = "original_name")
    public String original_name;

    public SearchesResult() { }

    public SearchesResult(String title) {
        this.title = title;
    }

    public String getOriginal_name() {
        return original_name;
    }

    public void setOriginal_name(String original_name) {
        this.original_name = original_name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
