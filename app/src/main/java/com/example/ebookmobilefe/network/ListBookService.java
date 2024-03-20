package com.example.ebookmobilefe.network;

import com.example.ebookmobilefe.model.ListBookResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ListBookService {
    @GET("v1/api/book/admin/getall-books")
    Call<ListBookResponse> getAllBook();
}