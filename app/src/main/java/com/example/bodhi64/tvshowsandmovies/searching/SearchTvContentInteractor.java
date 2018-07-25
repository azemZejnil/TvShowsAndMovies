package com.example.bodhi64.tvshowsandmovies.searching;

import com.example.bodhi64.tvshowsandmovies.model.SearchesResult;

import java.util.List;

import io.reactivex.Observable;



public interface SearchTvContentInteractor {

    Observable<List<SearchesResult>> findContent(String keyword);
    Observable<List<SearchesResult>> findShows(String keyword);
}
