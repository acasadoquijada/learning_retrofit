package com.example.retofit_app.retrofit;

import android.util.Log;

import com.example.retofit_app.model.RSSFeed;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class Controller  implements Callback<RSSFeed> {

    static final String BASE_URL = "http://vogella.com/";


    public void start() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(SimpleXmlConverterFactory.create()).build();

        VogellaAPI vogellaAPI = retrofit.create(VogellaAPI.class);

        Call<RSSFeed> call = vogellaAPI.loadRSSFeed();
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<RSSFeed> call, Response<RSSFeed> response) {
        if (response.isSuccessful()) {
            RSSFeed rss = response.body();

            assert rss != null;
            Log.d("RETROFIT__","Channel title: " + rss.getChannelTitle());

            for(int i = 0; i < rss.getArticleList().size(); i++){
                Log.d("RETROFIT__", "Title: " + rss.getArticleList().get(i).getTitle() + " Link: " + rss.getArticleList().get(i).getLink());
            }
        } else {
            System.out.println(response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<RSSFeed> call, Throwable t) {
        t.printStackTrace();
    }
}
