package com.example.bodhi64.tvshowsandmovies.searching;

import android.util.Log;

import com.example.bodhi64.tvshowsandmovies.model.SearchesResult;

import java.util.Calendar;
import java.util.List;
import java.util.Observable;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class SearchingPresenterImpl implements SearchingPresenter {

    private Disposable searchedContent;
    SearchingView view;
    SearchTvContentInteractor interactor;

    public SearchingPresenterImpl(SearchTvContentInteractor interactor) {
        this.interactor = interactor;
    }


    @Override
    public void displayContent(String keyword) {
        searchedContent=interactor.findContent(keyword)
                .subscribeOn(Schedulers.io())
                .flatMapIterable(new Function<List<SearchesResult>, List<SearchesResult>>() {
                    @Override public List<SearchesResult> apply(List<SearchesResult> v) {
                        return v;
                    }
                })
                .filter(new Predicate<SearchesResult>() {
                    @Override
                    public boolean test(SearchesResult v) {
                        return v.getTitle().startsWith(keyword);
                    }
                })
                .toList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onContentProvided, this::noContent);
    }

    @Override
    public void displayShows(String keyword) {
        searchedContent=interactor.findShows(keyword)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onContentProvided, this::noContent);

    }



    private void onContentProvided(List<SearchesResult> searchesResult) {
        view.showContent(searchesResult);
    }

    private void noContent(Throwable throwable) {
        Log.e("content","no content"+throwable.getMessage());
    }

    @Override
    public void setView(SearchingView view) {
        this.view=view;
    }

    @Override
    public void destroy() {

    }

}
