package com.example.bodhi64.tvshowsandmovies.movies_listing;

import dagger.Subcomponent;

@MoviesListingScope
@Subcomponent(modules = {MoviesListingModule.class})
public interface MoviesListingComponent {
    MoviesFragment inject(MoviesFragment fragment);
}
