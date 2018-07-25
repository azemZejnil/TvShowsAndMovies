package com.example.bodhi64.tvshowsandmovies.network;

import com.example.bodhi64.tvshowsandmovies.model.MoviesWraper;
import com.example.bodhi64.tvshowsandmovies.model.ResultsWrapper;
import com.example.bodhi64.tvshowsandmovies.model.ReviewsWrapper;
import com.example.bodhi64.tvshowsandmovies.model.TvShowsWrapper;
import com.example.bodhi64.tvshowsandmovies.model.VideoWrapper;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TmdbWebService {
    @GET("3/discover/movie?vote_count.gte=500&language=en&sort_by=vote_average.desc")
    Observable<MoviesWraper> highestRatedMovies();

    @GET("3/discover/tv?vote_count.gte=500&language=en&sort_by=vote_average.desc")
    Observable<TvShowsWrapper> highestRatedTvShows();

    @GET("3/movie/{movieId}/videos")
    Observable<VideoWrapper> trailers(@Path("movieId") String movieId);

    @GET("3/movie/{movieId}/reviews")
    Observable<ReviewsWrapper> reviews(@Path("movieId") String movieId);

    @GET("3/search/movie")
    Observable<ResultsWrapper> getNamedContent(@Query("query")String query);

    @GET("3/search/tv")
    Observable<ResultsWrapper> getNamedShow(@Query("query")String query);
}
