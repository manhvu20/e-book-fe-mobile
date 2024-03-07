package com.example.ebookmobilefe.ui.view;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.ebookmobilefe.R;
import com.example.ebookmobilefe.databinding.ActivityLoginBinding;
import com.example.ebookmobilefe.databinding.ActivityMainBinding;
import com.example.ebookmobilefe.network.RetrofitInstance;
import com.example.ebookmobilefe.viewmodel.LoginViewModel;

import retrofit2.Retrofit;

public class LoginActivity extends AppCompatActivity {

    // Assuming this is in an Activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Binding setup
        ActivityLoginBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        LoginViewModel viewModel = new LoginViewModel();
        binding.setLoginViewModel(viewModel);
    }
}
