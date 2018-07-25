package com.example.bodhi64.tvshowsandmovies.tvshows_listing;
import com.example.bodhi64.tvshowsandmovies.model.TVShow;

import java.util.List;
import io.reactivex.Observable;


public interface TVShowsListingInteractor {

    Observable<List<TVShow>> fetchTVShows();
}
