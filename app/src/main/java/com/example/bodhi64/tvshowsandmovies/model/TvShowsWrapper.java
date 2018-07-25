package com.example.bodhi64.tvshowsandmovies.model;

import com.squareup.moshi.Json;

import java.util.List;

public class TvShowsWrapper {

    @Json(name = "results")
    private List<TVShow> tvShows;

    public  List<TVShow> getTvShows() {
        return tvShows;
    }

    public void setTvShows(List<TVShow> tvShows) {
        this.tvShows = tvShows;
    }
}
