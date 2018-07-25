package com.example.bodhi64.tvshowsandmovies.model;

import com.squareup.moshi.Json;

import java.util.List;

public class ResultsWrapper {

    @Json(name = "results")
    private List<SearchesResult> searchesResults;

    public List<SearchesResult> getSearchesResults() {
        return searchesResults;
    }

    public void setSearchesResults(List<SearchesResult> movieList) {
        this.searchesResults = movieList;
    }
}
