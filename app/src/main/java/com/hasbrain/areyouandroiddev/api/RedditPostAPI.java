package com.hasbrain.areyouandroiddev.api;

import com.hasbrain.areyouandroiddev.datastore.FeedDataStore;
import com.hasbrain.areyouandroiddev.model.RedditPost;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by Dell on 05/12/2016.
 */

public interface RedditPostAPI {
    String BASE_URL = "http://by.originally.us/";

    @GET("temp/fake_job_posting.json")
    Call<List<RedditPost>> getPost();

    class PostApiClass {
        private static RedditPostAPI service;

        public static RedditPostAPI getIntances() {
            if (service == null) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                service = retrofit.create(RedditPostAPI.class);
                return service;
            } else
                return service;
        }

    }


}
