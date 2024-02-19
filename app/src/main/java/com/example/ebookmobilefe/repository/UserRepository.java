package com.example.ebookmobilefe.repository;

import android.app.Application;
import android.util.Log;

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
    private Application application;
    private MutableLiveData<LoginResponse> mutableLiveData = new MutableLiveData<>();

    public UserRepository(Application application) {
        this.application = application;
    }

    public static void signOut() {
    }

    public MutableLiveData<LoginResponse> getLoginResponse() {
        return mutableLiveData;
    }

    public MutableLiveData<Boolean> login(String username, String password) {
        MutableLiveData<Boolean> loginResult = new MutableLiveData<>();
        LoginService loginService = RetrofitInstance.getRetrofitInstance().create(LoginService.class);

        LoginRequest request = new LoginRequest(username, password);
        loginService.loginUser(request).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    // Handle successful response
                    loginResult.setValue(true);
                } else {
                    // Handle unsuccessful response, e.g., wrong credentials
                    loginResult.setValue(false);
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                // Handle network failure or other system issues
                loginResult.setValue(false);
            }
        });

        return loginResult;
    }
}
