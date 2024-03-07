package com.example.ebookmobilefe.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.ebookmobilefe.model.LoginRequest;
import com.example.ebookmobilefe.model.LoginResponse;
import com.example.ebookmobilefe.model.User;
import com.example.ebookmobilefe.network.LoginService;
import com.example.ebookmobilefe.network.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {

    public MutableLiveData<User> getUserData(String userId) {
        MutableLiveData<User> userData = new MutableLiveData<>();
        // Implement logic to fetch user data
        return userData;
    }

    public MutableLiveData<Boolean> login(String username, String password) {
        MutableLiveData<Boolean> loginResult = new MutableLiveData<>();
        LoginService loginService = RetrofitInstance.getRetrofitInstance().create(LoginService.class);
        loginService.loginUser(new LoginRequest(username, password)).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()) {
                    loginResult.setValue(true);
                } else {
                    loginResult.setValue(false);
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                loginResult.setValue(false);
            }
        });

        return loginResult;
    }
}
