package com.example.bodhi64.tvshowsandmovies.details;

import com.example.bodhi64.tvshowsandmovies.model.Movie;

public interface DetailsPresenter {
    void showDetails(Movie movie);

    void showTrailers(Movie movie);

    void showReviews(Movie movie);


    void setView(DetailsView view);

    void destroy();
}