package com.example.bodhi64.tvshowsandmovies.movies_listing;

import com.example.bodhi64.tvshowsandmovies.ListingInteractorImpl;
import com.example.bodhi64.tvshowsandmovies.network.TmdbWebService;

import dagger.Module;
import dagger.Provides;

@Module
public class MoviesListingModule {

    @Provides
    MoviesListingInteractor provideMovieListingInteractor(TmdbWebService tmdbWebService){
        return new ListingInteractorImpl(tmdbWebService);
    }

    @Provides
    MoviesListingPresenter provideMoviesListingPresenter(MoviesListingInteractor interactor){
        return new MoviesListingPresenterImpl(interactor);
    }

}
