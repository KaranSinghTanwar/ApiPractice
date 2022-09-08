package com.example.apipractice10july22;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("posts")
    Call<Modal> getpost();




}
