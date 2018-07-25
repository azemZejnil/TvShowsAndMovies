package com.example.bodhi64.tvshowsandmovies.tvshows_listing;

import com.example.bodhi64.tvshowsandmovies.model.TVShow;

import java.util.List;

public interface TVShowListingView {
    void loadingStarted();
    void loadingFailed(String errorMessage);



    void showTVShows(List<TVShow> tvShows);
    void onTvShowClicked(TVShow tvShow);
}
