package com.example.ebookmobilefe.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.example.ebookmobilefe.model.LoginResponse;
import com.example.ebookmobilefe.repository.UserRepository;

public class LoginViewModel extends AndroidViewModel {
    private final MutableLiveData<Boolean> loginResult = new MutableLiveData<>();
    private final UserRepository userRepository;

    // Expose LiveData for username and password to observe their changes
    private final MutableLiveData<String> username = new MutableLiveData<>();
    private final MutableLiveData<String> password = new MutableLiveData<>();

    public LoginViewModel(@NonNull Application application) {
        super(application);
        userRepository = new UserRepository(application);
    }

    public LiveData<Boolean> getLoginResult() {
        return loginResult;
    }

    public MutableLiveData<String> getUsername() {
        return username;
    }

    public MutableLiveData<String> getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username.setValue(username);
    }

    public void setPassword(String password) {
        this.password.setValue(password);
    }

    // Call this method when the login button is clicked
    public void login() {
        String user = username.getValue();
        String pass = password.getValue();
        LiveData<Boolean> repoResult = userRepository.login(user, pass);
        repoResult.observeForever(isSuccess -> loginResult.setValue(isSuccess));
    }

    public void signOut() {
    }
}
