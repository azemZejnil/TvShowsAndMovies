package com.example.bodhi64.tvshowsandmovies.searching;

import com.example.bodhi64.tvshowsandmovies.network.TmdbWebService;

import dagger.Module;
import dagger.Provides;

@Module
public class SearchingModule {

    @Provides
    SearchTvContentInteractor provideSearchTVContentInteractor(TmdbWebService tmdbWebService){
        return new SearchTvContentInteractorImpl(tmdbWebService);
    }

    @Provides
    SearchingPresenter provideSearchingPresenter(SearchTvContentInteractor interactor){
        return  new SearchingPresenterImpl(interactor);
    }

}
