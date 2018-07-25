package com.example.bodhi64.tvshowsandmovies.movies_listing;

import com.example.bodhi64.tvshowsandmovies.model.Movie;

import java.util.List;

public interface MoviesListingView {

    void loadingStarted();
    void loadingFailed(String errorMessage);



    void showMovies(List<Movie> movies);
    void onMovieClicked(Movie movie);

}
