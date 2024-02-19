package com.example.ebookmobilefe.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.ebookmobilefe.command.AccessCmd.LoginCommand;
import com.example.ebookmobilefe.command.AccessCmd.SignOutCommand;
import com.example.ebookmobilefe.command.ICommand;
import com.example.ebookmobilefe.repository.UserRepository;

public class LoginViewModel extends AndroidViewModel {
    private MutableLiveData<Boolean> loginResult = new MutableLiveData<>();
    private UserRepository userRepository;

    public LiveData<Boolean> getLoginResult() {
        return loginResult;
    }

    public final ObservableField<String> Username = new ObservableField<>();
    public final ObservableField<String> Password = new ObservableField<>();

    public ICommand loginCommand;

    public ICommand signOutCommand;

    public LoginViewModel(@NonNull Application application) {
        super(application);
        loginCommand = new LoginCommand(() -> login(Username, Password));
        signOutCommand = new SignOutCommand(() -> signOut());
        this.userRepository = new UserRepository(application);
        Username.set("");
        Password.set("");
    }

    public void login(ObservableField<String> Username, ObservableField<String> Password) {
        userRepository.login(Username.get(), Password.get()).observe(getApplication(), loginResponse -> {
            loginResult.setValue(true);
        });
    }

    public void signOut() {
        UserRepository.signOut();
    }


    public void onLoginClicked() {
        if (((LoginCommand)loginCommand).canExecute()) {
            loginCommand.execute();
        }
    }

    public LiveData<Boolean> getNavigateToMain() {
        return loginResult;
    }
}
