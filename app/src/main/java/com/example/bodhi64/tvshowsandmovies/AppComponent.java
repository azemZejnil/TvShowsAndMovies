package com.example.bodhi64.tvshowsandmovies;

import com.example.bodhi64.tvshowsandmovies.details.DetailsComponent;
import com.example.bodhi64.tvshowsandmovies.details.DetailsModule;
import com.example.bodhi64.tvshowsandmovies.network.NetworkModule;
import com.example.bodhi64.tvshowsandmovies.movies_listing.MoviesListingComponent;
import com.example.bodhi64.tvshowsandmovies.movies_listing.MoviesListingModule;
import com.example.bodhi64.tvshowsandmovies.searching.SearchingComponent;
import com.example.bodhi64.tvshowsandmovies.searching.SearchingModule;
import com.example.bodhi64.tvshowsandmovies.tvshows_listing.TVShowListingComponent;
import com.example.bodhi64.tvshowsandmovies.tvshows_listing.TVShowListingModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, NetworkModule.class})
public interface AppComponent {
    MoviesListingComponent plus(MoviesListingModule listingModule);

    TVShowListingComponent plus(TVShowListingModule listingModule);

    SearchingComponent plus(SearchingModule searchingModule);

    DetailsComponent plus(DetailsModule detailsModule);

}
