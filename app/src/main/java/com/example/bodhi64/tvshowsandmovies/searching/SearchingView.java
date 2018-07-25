package com.example.bodhi64.tvshowsandmovies.searching;

import com.example.bodhi64.tvshowsandmovies.model.SearchesResult;

import java.util.List;

public interface SearchingView {
    void showContent(List<SearchesResult> content);
    void onInputChanged(String keyword);
}
