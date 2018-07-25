package com.example.bodhi64.tvshowsandmovies.details;

import com.example.bodhi64.tvshowsandmovies.model.Movie;
import com.example.bodhi64.tvshowsandmovies.model.Review;
import com.example.bodhi64.tvshowsandmovies.model.Video;

import java.util.List;

public interface DetailsView {
    void showDetails(Movie movie);
    void showTrailers(List<Video> trailers);
    void showReviews(List<Review> reviews);
}
