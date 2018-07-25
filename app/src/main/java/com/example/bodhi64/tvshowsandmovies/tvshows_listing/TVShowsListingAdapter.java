package com.example.bodhi64.tvshowsandmovies.tvshows_listing;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.bodhi64.tvshowsandmovies.Api;
import com.example.bodhi64.tvshowsandmovies.R;
import com.example.bodhi64.tvshowsandmovies.model.TVShow;
import com.example.bodhi64.tvshowsandmovies.movies_listing.MoviesListingAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class TVShowsListingAdapter extends RecyclerView.Adapter<TVShowsListingAdapter.ViewHolder> {

    private List<TVShow> tvShows;
    private Context context;
    private TVShowListingView view;

    public TVShowsListingAdapter(List<TVShow> tvShows, TVShowListingView moviesView) {
        this.tvShows = tvShows;
        view = moviesView;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View rootView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);

        return new ViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(TVShowsListingAdapter.ViewHolder holder, int position) {
        Context context = holder.itemView.getContext();

        holder.itemView.setOnClickListener(holder);
        holder.tvShow = tvShows.get(position);
        holder.name.setText(holder.tvShow.getOriginal_name());


        RequestOptions options = new RequestOptions()
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .priority(Priority.HIGH);

        Glide.with(context)
                .asBitmap()
                .load(Api.getPosterPath(holder.tvShow.getPosterPath()))
                .apply(options)
                .into(new BitmapImageViewTarget(holder.poster));
    }

    @Override
    public int getItemCount() {
        return tvShows.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.movie_poster)
        CircleImageView poster;
        @BindView(R.id.movie_name)
        TextView name;



        public TVShow tvShow;

        public ViewHolder(View root) {
            super(root);
            ButterKnife.bind(this, root);
        }

        @Override
        public void onClick(View view) {
            TVShowsListingAdapter.this.view.onTvShowClicked(tvShow);
        }

    }

}