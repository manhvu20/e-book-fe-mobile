package com.example.ebookmobilefe.network;

import com.example.ebookmobilefe.model.User;

import retrofit2.Call;
import retrofit2.http.*;

public interface ApiService {
    @GET("users/{id}")
    Call<User> getUserById(@Path("id") String userId);
}
