package com.example.bodhi64.tvshowsandmovies.details;

import com.example.bodhi64.tvshowsandmovies.model.Review;
import com.example.bodhi64.tvshowsandmovies.model.ReviewsWrapper;
import com.example.bodhi64.tvshowsandmovies.model.Video;
import com.example.bodhi64.tvshowsandmovies.model.VideoWrapper;
import com.example.bodhi64.tvshowsandmovies.network.TmdbWebService;

import java.util.List;

import io.reactivex.Observable;

public class DetailsInteractorImpl implements DetailsInteractor {

    private TmdbWebService tmdbWebService;

    public DetailsInteractorImpl(TmdbWebService tmdbWebService) {
        this.tmdbWebService = tmdbWebService;
    }

    @Override
    public Observable<List<Video>> getTrailers(String id) {

        return tmdbWebService.trailers(id).map(VideoWrapper::getVideos);
    }

    @Override
    public Observable<List<Review>> getReviews(String id) {
        return tmdbWebService.reviews(id).map(ReviewsWrapper::getReviews);
    }
}
