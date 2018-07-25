package com.example.bodhi64.tvshowsandmovies.details;

import com.example.bodhi64.tvshowsandmovies.model.Review;
import com.example.bodhi64.tvshowsandmovies.model.Video;

import java.util.List;

import io.reactivex.Observable;

public interface DetailsInteractor {
    Observable<List<Video>> getTrailers(String id);
    Observable<List<Review>> getReviews(String id);
}
