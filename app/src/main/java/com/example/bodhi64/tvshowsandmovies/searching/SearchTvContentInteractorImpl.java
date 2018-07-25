package com.example.bodhi64.tvshowsandmovies.searching;

import com.example.bodhi64.tvshowsandmovies.model.SearchesResult;
import com.example.bodhi64.tvshowsandmovies.model.ResultsWrapper;
import com.example.bodhi64.tvshowsandmovies.network.TmdbWebService;

import java.util.List;

import io.reactivex.Observable;

public class SearchTvContentInteractorImpl implements SearchTvContentInteractor {



    private TmdbWebService tmdbWebService;

    public SearchTvContentInteractorImpl(TmdbWebService tmdbWebService) {
        this.tmdbWebService = tmdbWebService;
    }


    @Override
    public Observable<List<SearchesResult>> findContent(String keyword) {
        return tmdbWebService.getNamedContent(keyword).map(ResultsWrapper::getSearchesResults);
    }

    @Override
    public Observable<List<SearchesResult>> findShows(String keyword) {
        return tmdbWebService.getNamedShow(keyword).map(ResultsWrapper::getSearchesResults);
    }


}
