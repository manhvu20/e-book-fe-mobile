package com.example.ebookmobilefe.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.ebookmobilefe.model.User;

public class UserRepository {
    public MutableLiveData<User> getUserData(String userId) {
        MutableLiveData<User> userData = new MutableLiveData<>();

        // Implement logic to fetch data. For instance, use Retrofit to fetch data from a REST API

        return userData;
    }

    public static boolean login(String username, String password) {
        return username.equals("user") && password.equals("password");
    }
}
