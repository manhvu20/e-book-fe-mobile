package com.example.ebookmobilefe.network;

import com.example.ebookmobilefe.model.LoginRequest;
import com.example.ebookmobilefe.model.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginService {
    @POST("/v1/api/authen/shop/login")
    Call<LoginResponse> loginUser(@Body LoginRequest loginRequest);
}
