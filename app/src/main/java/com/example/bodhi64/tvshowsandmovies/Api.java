package com.example.bodhi64.tvshowsandmovies;

public class Api {

    public static final String BASE_POSTER_PATH = "http://image.tmdb.org/t/p/w342";
    public static final String BASE_BACKDROP_PATH = "http://image.tmdb.org/t/p/w780";
    public static final String TMDB_API_KEY = "1a329732227e4448fd5ee03e3e2a7f8c";
    public static final String TMDB_BASE_URL = "http://api.themoviedb.org/";
    public static final String YOUTUBE_THUMBNAIL_URL = "http://img.youtube.com/vi/%1$s/0.jpg";
    public static final String YOUTUBE_VIDEO_URL = "http://www.youtube.com/watch?v=%1$s";


    public static String getPosterPath(String posterPath) {
        return BASE_POSTER_PATH + posterPath;
    }


    public static String getBackdropPath(String backdropPath) {
        return BASE_BACKDROP_PATH + backdropPath;
    }
}
