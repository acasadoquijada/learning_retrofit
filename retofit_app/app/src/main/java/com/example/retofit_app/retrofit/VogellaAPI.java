package com.example.retofit_app.retrofit;

import com.example.retofit_app.model.RSSFeed;

import retrofit2.Call;
import retrofit2.http.GET;

public interface VogellaAPI {

    @GET("article.rss")
    Call<RSSFeed> loadRSSFeed();
}
