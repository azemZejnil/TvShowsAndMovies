package com.example.bodhi64.tvshowsandmovies.tvshows_listing;


public interface TvShowsListingPresenter {

    void displayTVShows();

    void setView(TVShowListingView view);

    void destroy();
}
