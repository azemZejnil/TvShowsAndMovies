package com.example.bodhi64.tvshowsandmovies.model;

import com.squareup.moshi.Json;

import java.util.List;



public class ReviewsWrapper {

    @Json(name = "results")
    private List<Review> reviews;

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
