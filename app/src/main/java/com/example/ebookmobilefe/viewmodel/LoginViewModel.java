package com.example.ebookmobilefe.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.ebookmobilefe.repository.UserRepository;

public class LoginViewModel extends ViewModel {
    private MutableLiveData<Boolean> loginResult = new MutableLiveData<>();

    public LiveData<Boolean> getLoginResult() {
        return loginResult;
    }

    public void login(String username, String password) {
        // Assume UserRepository handles the actual authentication logic
        boolean isSuccess = UserRepository.login(username, password);
        loginResult.setValue(isSuccess);
    }
}

