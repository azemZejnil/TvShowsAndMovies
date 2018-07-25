package com.example.bodhi64.tvshowsandmovies.details;

import com.example.bodhi64.tvshowsandmovies.network.TmdbWebService;

import dagger.Module;
import dagger.Provides;

@Module
public class DetailsModule {

    @Provides
    @DetailsScope
    DetailsInteractor provideInteractor(TmdbWebService tmdbWebService){
        return new DetailsInteractorImpl(tmdbWebService);
    }

    @Provides
    @DetailsScope
    DetailsPresenter providePresenter(DetailsInteractor detailsInteractor){
        return new DetailsPresenterImpl(detailsInteractor);
    }
}
