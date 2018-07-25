package com.example.bodhi64.tvshowsandmovies.searching;

import dagger.Subcomponent;

@SearchingScope
@Subcomponent(modules = {SearchingModule.class})
public interface SearchingComponent {
    SearchingFragment inject(SearchingFragment searchingFragment);
}
