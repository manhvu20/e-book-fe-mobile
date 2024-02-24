package com.example.ebookmobilefe.repository;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.ebookmobilefe.model.LoginRequest;
import com.example.ebookmobilefe.model.LoginResponse;
import com.example.ebookmobilefe.network.LoginService;
import com.example.ebookmobilefe.network.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {
    private Application application;

    public UserRepository(Application application) {
        this.application = application;
    }

    public LiveData<Boolean> login(String username, String password) {
        final MutableLiveData<Boolean> loginResult = new MutableLiveData<>();

        LoginService loginService = RetrofitInstance.getRetrofitInstance().create(LoginService.class);
        LoginRequest request = new LoginRequest(username, password);

        loginService.loginUser(request).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful() && response.body() != null && response.body().isSuccess()) {
                    loginResult.postValue(true);
                } else {
                    loginResult.postValue(false);
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                loginResult.postValue(false);
            }
        });

        return loginResult;
    }
}
