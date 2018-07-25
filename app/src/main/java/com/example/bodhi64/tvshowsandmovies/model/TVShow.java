package com.example.bodhi64.tvshowsandmovies.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.squareup.moshi.Json;

public class TVShow implements Parcelable {

    private String original_name;
    @Json(name = "poster_path")
    private String posterPath;



    public TVShow() {
    }

    protected TVShow(Parcel in) {
    }

    public String getOriginal_name() {
        return original_name;
    }

    public void setOriginal_name(String original_name) {
        this.original_name = original_name;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }


    public static final Creator<TVShow> CREATOR = new Creator<TVShow>() {
        @Override
        public TVShow createFromParcel(Parcel in) {
            return new TVShow(in);
        }

        @Override
        public TVShow[] newArray(int size) {
            return new TVShow[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
