package com.example.ebookmobilefe.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.ebookmobilefe.model.ListBookResponse;
import com.example.ebookmobilefe.network.ListBookService;
import com.example.ebookmobilefe.network.RetrofitInstance;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookRepository {
    public BookRepository() {
    }

    public LiveData<ListBookResponse> getAllBook() {
        final MutableLiveData<ListBookResponse> listBookResult = new MutableLiveData<>();

        ListBookService listBookService = RetrofitInstance.getRetrofitInstance().create(ListBookService.class);
        listBookService.getAllBook().enqueue(new Callback<ListBookResponse>() {
            @Override
            public void onResponse(Call<ListBookResponse> call, Response<ListBookResponse> response) {
                if (response.isSuccessful() && response.body() != null && Objects.equals(response.body().getStatus(),"200")){
                    listBookResult.postValue(response.body());
                } else {
                    listBookResult.postValue(null);
                }
            }

            @Override
            public void onFailure(Call<ListBookResponse> call, Throwable t) {
                listBookResult.postValue(null);
            }
        });

        return listBookResult;
    }
}
