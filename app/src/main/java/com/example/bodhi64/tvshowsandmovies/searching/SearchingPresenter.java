package com.example.bodhi64.tvshowsandmovies.searching;

public interface SearchingPresenter {

    void displayContent(String keyword);
    void displayShows(String keyword);
    void setView(SearchingView view);
    void destroy();
}
