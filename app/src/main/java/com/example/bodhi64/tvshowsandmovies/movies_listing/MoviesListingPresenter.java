package com.example.bodhi64.tvshowsandmovies.movies_listing;

public interface MoviesListingPresenter {

    void displayMovies();

    void setView(MoviesListingView view);

    void destroy();
}
