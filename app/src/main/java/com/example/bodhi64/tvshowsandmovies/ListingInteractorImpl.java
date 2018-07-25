package com.example.bodhi64.tvshowsandmovies;

import com.example.bodhi64.tvshowsandmovies.model.Movie;
import com.example.bodhi64.tvshowsandmovies.model.MoviesWraper;
import com.example.bodhi64.tvshowsandmovies.model.TVShow;
import com.example.bodhi64.tvshowsandmovies.model.TvShowsWrapper;
import com.example.bodhi64.tvshowsandmovies.movies_listing.MoviesListingInteractor;
import com.example.bodhi64.tvshowsandmovies.network.TmdbWebService;
import com.example.bodhi64.tvshowsandmovies.tvshows_listing.TVShowsListingInteractor;

import java.util.List;

import io.reactivex.Observable;

public class ListingInteractorImpl implements MoviesListingInteractor,TVShowsListingInteractor {

    private TmdbWebService tmdbWebService;


    public ListingInteractorImpl(TmdbWebService tmdbWebService) {
        this.tmdbWebService = tmdbWebService;
    }

    @Override
    public Observable<List<Movie>> fetchMovies() {
        return tmdbWebService.highestRatedMovies().map(MoviesWraper::getMovieList);
    }

    @Override
    public Observable<List<TVShow>> fetchTVShows(){
        return tmdbWebService.highestRatedTvShows().map(TvShowsWrapper::getTvShows);
    }

}
