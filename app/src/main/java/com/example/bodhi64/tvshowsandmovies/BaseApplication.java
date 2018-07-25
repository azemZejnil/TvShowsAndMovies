package com.example.bodhi64.tvshowsandmovies;

import android.app.Application;
import android.os.StrictMode;

import com.example.bodhi64.tvshowsandmovies.details.DetailsComponent;
import com.example.bodhi64.tvshowsandmovies.details.DetailsModule;
import com.example.bodhi64.tvshowsandmovies.movies_listing.MoviesListingComponent;
import com.example.bodhi64.tvshowsandmovies.movies_listing.MoviesListingModule;
import com.example.bodhi64.tvshowsandmovies.network.NetworkModule;
import com.example.bodhi64.tvshowsandmovies.searching.SearchingComponent;
import com.example.bodhi64.tvshowsandmovies.searching.SearchingModule;
import com.example.bodhi64.tvshowsandmovies.tvshows_listing.TVShowListingComponent;
import com.example.bodhi64.tvshowsandmovies.tvshows_listing.TVShowListingModule;
import com.example.bodhi64.tvshowsandmovies.tvshows_listing.TvShowsListingPresenter;

public class BaseApplication extends Application {

    private MoviesListingComponent moviesListingComponent;
    private TVShowListingComponent tvShowsListingComponent;
    SearchingComponent searchingComponent;
    private DetailsComponent detailsComponent;

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        StrictMode.enableDefaults();
        appComponent=createAppComponent();
    }

    private AppComponent createAppComponent() {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule())
                .build();
    }

    public MoviesListingComponent createMoviesListingComponent() {
        moviesListingComponent=appComponent.plus(new MoviesListingModule());
        return moviesListingComponent;
    }

    public TVShowListingComponent createTvShowsListingComponent() {
        tvShowsListingComponent=appComponent.plus(new TVShowListingModule());
        return tvShowsListingComponent;
    }

    public SearchingComponent createSearchingComponent() {
        searchingComponent=appComponent.plus(new SearchingModule());
        return searchingComponent;
    }

    public DetailsComponent createDetailsComponent()
    {
        detailsComponent = appComponent.plus(new DetailsModule());
        return detailsComponent;
    }

    public void releaseDetailsComponent()
    {
        detailsComponent = null;
    }
    public void releaseMoviesListingComponent()
    {
        moviesListingComponent = null;
    }
    public void releaseTvShowsListingComponent()
    {
        tvShowsListingComponent = null;
    }
    public void releaseSearchingComponent()
    {
        searchingComponent = null;
    }


    public MoviesListingComponent getMoviesListingComponent()
    {
        return moviesListingComponent;
    }

    public TVShowListingComponent getTvShowsListingComponent()
    {
        return tvShowsListingComponent;
    }

    public SearchingComponent getSearchingComponent()
    {
        return searchingComponent;
    }
}
