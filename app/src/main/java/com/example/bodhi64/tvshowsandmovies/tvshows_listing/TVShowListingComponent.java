package com.example.bodhi64.tvshowsandmovies.tvshows_listing;

import dagger.Subcomponent;

@TVShowListingScope
@Subcomponent(modules = {TVShowListingModule.class})
public interface TVShowListingComponent {
    TVShowsFragment inject(TVShowsFragment tvShowsFragment);
}
