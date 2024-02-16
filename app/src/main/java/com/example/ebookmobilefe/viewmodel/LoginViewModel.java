package com.example.ebookmobilefe.viewmodel;

import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.ebookmobilefe.command.AccessCmd.SubmitLoginCommand;
import com.example.ebookmobilefe.repository.UserRepository;

public class LoginViewModel extends ViewModel {
    private MutableLiveData<Boolean> loginResult = new MutableLiveData<>();
    private UserRepository userRepository = new UserRepository();

    public LiveData<Boolean> getLoginResult() {
        return loginResult;
    }

    public final ObservableField<String> Username = new ObservableField<>();
    public final ObservableField<String> Password = new ObservableField<>();

    public SubmitLoginCommand submitLoginCommand;

    public LoginViewModel() {
        submitLoginCommand = this::login;
        Username.set("");
        Password.set("");
    }

    public void login(String username, String password) {
        if(username != null && password != null) {
            LiveData<Boolean> repoLoginResult = userRepository.login(username, password);
            repoLoginResult.observeForever(loginResult::setValue);
        }
    }

    public void onLoginClicked() {
        if (submitLoginCommand != null) {
            submitLoginCommand.execute(Username.get(), Password.get());
        }
    }
}
