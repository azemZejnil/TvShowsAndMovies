package com.example.bodhi64.tvshowsandmovies.details;

import com.example.bodhi64.tvshowsandmovies.RxUtils;
import com.example.bodhi64.tvshowsandmovies.model.Movie;
import com.example.bodhi64.tvshowsandmovies.model.Review;
import com.example.bodhi64.tvshowsandmovies.model.Video;

import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class DetailsPresenterImpl implements DetailsPresenter {

    private DetailsView view;
    private DetailsInteractor detailsInteractor;
    private Disposable trailersSubscription;
    private Disposable reviewsSubscription;

    public DetailsPresenterImpl(DetailsInteractor detailsInteractor) {
        this.detailsInteractor = detailsInteractor;
    }

    @Override
    public void setView(DetailsView view) {
        this.view=view;
    }

    @Override
    public void destroy() {
        view=null;
        RxUtils.unsubscribe(trailersSubscription,reviewsSubscription);
    }

    @Override
    public void showDetails(Movie movie) {
        if(isViewAttached()){
            view.showDetails(movie);
        }
    }
    private boolean isViewAttached() {
        return view != null;
    }


    @Override
    public void showTrailers(Movie movie) {
        trailersSubscription=detailsInteractor.getTrailers(movie.getId())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onGetTrailersSuccess, t -> onGetTrailersFailure());
    }

    private void onGetTrailersSuccess(List<Video> videos) {
        if (isViewAttached()) {
            view.showTrailers(videos);
        }
    }

    private void onGetTrailersFailure() {
        // Do nothing
    }


    @Override
    public void showReviews(Movie movie) {
        reviewsSubscription=detailsInteractor.getReviews(movie.getId())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onGetReviewsSuccess, t -> onGetReviewsFailure());
    }

    private void onGetReviewsSuccess(List<Review> reviews) {
        if (isViewAttached()) {
            view.showReviews(reviews);
        }
    }

    private void onGetReviewsFailure() {
        // Do nothing
    }



}
