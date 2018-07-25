package com.example.bodhi64.tvshowsandmovies.tvshows_listing;

import com.example.bodhi64.tvshowsandmovies.RxUtils;
import com.example.bodhi64.tvshowsandmovies.model.TVShow;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class TVShowListingPresenterImpl implements TvShowsListingPresenter {

    private TVShowListingView view;
    private TVShowsListingInteractor interactor;
    private Disposable fetchSubscirption;

    public TVShowListingPresenterImpl(TVShowsListingInteractor interactor) {
        this.interactor = interactor;
    }


    @Override
    public void setView(TVShowListingView view) {
        this.view=view;
        displayTVShows();
    }


    @Override
    public void destroy() {
        this.view=null;
        RxUtils.unsubscribe(fetchSubscirption);
    }

    @Override
    public void displayTVShows() {
        showLoading();
        fetchSubscirption=interactor.fetchTVShows()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onMovieFetchSuccess,this::onMovieFetchFailed);
    }


    private void showLoading() {
        if (isViewAttached()) {
            view.loadingStarted();
        }
    }

    private void onMovieFetchSuccess(List<TVShow> tvShows) {
        if (isViewAttached()) {
            view.showTVShows(tvShows);
        }
    }

    private void onMovieFetchFailed(Throwable e) {
        view.loadingFailed(e.getMessage());
    }


    private boolean isViewAttached() {
        return view != null;
    }

}
