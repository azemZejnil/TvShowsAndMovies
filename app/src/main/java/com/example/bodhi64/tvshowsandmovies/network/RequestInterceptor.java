package com.example.bodhi64.tvshowsandmovies.network;

import com.example.bodhi64.tvshowsandmovies.Api;
import com.example.bodhi64.tvshowsandmovies.BuildConfig;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

@Singleton
public class RequestInterceptor implements Interceptor {

    @Inject
    public RequestInterceptor (){

    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originalRequest= chain.request();
        HttpUrl originalUrl = originalRequest.url();

        HttpUrl url = originalUrl.newBuilder()
                .addQueryParameter("api_key", Api.TMDB_API_KEY)
                .build();
        Request request= originalRequest.newBuilder().url(url).build();
        return chain.proceed(request);
    }

}
