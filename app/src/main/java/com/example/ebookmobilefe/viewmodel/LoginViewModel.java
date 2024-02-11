package com.example.ebookmobilefe.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.ebookmobilefe.repository.UserRepository;

public class LoginViewModel extends ViewModel {
    private MutableLiveData<Boolean> loginResult = new MutableLiveData<>();

    private UserRepository userRepository = new UserRepository();

    public LiveData<Boolean> getLoginResult() {
        return loginResult;
    }

    public void login(String username, String password) {
        LiveData<Boolean> repoLoginResult = userRepository.login(username, password);
        repoLoginResult.observeForever(isSuccess -> {
            loginResult.setValue(isSuccess);
        });
    }
}
