package com.example.project1;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

import java.util.List;

public interface APIinterface {
    //@GET("/data/api/post")
    //Call<Post> doGetPost();

    @Headers("app-id: 6086b15b9411fd9924eb2f26")
    @GET("/data/api/post")
    Call<List<Post>> getPosts();
}
