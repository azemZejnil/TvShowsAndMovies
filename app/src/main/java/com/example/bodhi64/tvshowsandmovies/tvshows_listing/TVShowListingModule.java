package com.example.bodhi64.tvshowsandmovies.tvshows_listing;

import com.example.bodhi64.tvshowsandmovies.ListingInteractorImpl;
import com.example.bodhi64.tvshowsandmovies.movies_listing.MoviesListingInteractor;
import com.example.bodhi64.tvshowsandmovies.movies_listing.MoviesListingPresenter;
import com.example.bodhi64.tvshowsandmovies.movies_listing.MoviesListingPresenterImpl;
import com.example.bodhi64.tvshowsandmovies.network.TmdbWebService;

import java.util.Observable;

import dagger.Module;
import dagger.Provides;

@Module
public class TVShowListingModule {

    @Provides
    TVShowsListingInteractor provideTvShowListingInteractor(TmdbWebService tmdbWebService){
        return new ListingInteractorImpl(tmdbWebService);
    }


    @Provides
    TvShowsListingPresenter provideMoviesListingPresenter(TVShowsListingInteractor interactor){
        return new TVShowListingPresenterImpl(interactor);
    }

}
