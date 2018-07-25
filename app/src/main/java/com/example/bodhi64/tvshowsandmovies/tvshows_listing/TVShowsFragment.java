package com.example.bodhi64.tvshowsandmovies.tvshows_listing;


import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bodhi64.tvshowsandmovies.BaseApplication;
import com.example.bodhi64.tvshowsandmovies.R;
import com.example.bodhi64.tvshowsandmovies.model.TVShow;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class TVShowsFragment extends Fragment implements TVShowListingView{

    @Inject
    TvShowsListingPresenter tvShowListingPresenter;

    @BindView(R.id.movies_listing)
    RecyclerView moviesListing;

    private RecyclerView.Adapter adapter;
    private List<TVShow> tvShows = new ArrayList<>(10);
    private Callback callback;
    private Unbinder unbinder;


    public TVShowsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Callback) {
            callback=(Callback)context;
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        ((BaseApplication) getActivity().getApplication()).createTvShowsListingComponent().inject(this);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_movies, container, false);
        unbinder= ButterKnife.bind(this,v);
        initLayoutReferences();
        return v;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(savedInstanceState!=null){
            tvShows = savedInstanceState.getParcelableArrayList("tvshow");
            adapter.notifyDataSetChanged();
            moviesListing.setVisibility(View.VISIBLE);
        } else {
            tvShowListingPresenter.setView(this);
        }
    }

    private void initLayoutReferences() {
        moviesListing.setHasFixedSize(true);
        LinearLayoutManager layoutManager= new LinearLayoutManager(getContext());
        moviesListing.setLayoutManager(layoutManager);
        adapter= new TVShowsListingAdapter(tvShows,this);
        moviesListing.setAdapter(adapter);
    }

    @Override
    public void loadingStarted() {
        Snackbar.make(moviesListing, R.string.loading_movies, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void loadingFailed(String errorMessage) {
        Snackbar.make(moviesListing, errorMessage, Snackbar.LENGTH_INDEFINITE).show();
    }

    @Override
    public void showTVShows(List<TVShow> tvShows) {
        this.tvShows.clear();
        this.tvShows.addAll(tvShows);
        moviesListing.setVisibility(View.VISIBLE);
        adapter.notifyDataSetChanged();
        if(callback!=null)
        callback.onTvShowsLoaded(tvShows.get(0));
    }

    @Override
    public void onTvShowClicked(TVShow tvShow) {
        callback.onTvShowsClicked(tvShow);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        tvShowListingPresenter.destroy();
        unbinder.unbind();
    }


    @Override
    public void onDetach() {
        callback = null;
        super.onDetach();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ((BaseApplication) getActivity().getApplication()).releaseTvShowsListingComponent();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("tvshow", (ArrayList<? extends Parcelable>) tvShows);
    }

    public interface Callback {
        void onTvShowsLoaded(TVShow tvShow);

        void onTvShowsClicked(TVShow tvShow);
    }
}
