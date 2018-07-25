package com.example.bodhi64.tvshowsandmovies.movies_listing;

import com.example.bodhi64.tvshowsandmovies.model.Movie;

import java.util.List;
import io.reactivex.Observable;


/**
 *

 this interface is implemented by ListingInteractorImpl
  ListingInteractorImpl is in main package

ListingInteractorImpl also implements TvShowsListingInteractor

 */

public interface MoviesListingInteractor {

    Observable<List<Movie>> fetchMovies();
}
