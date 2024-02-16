package com.example.ebookmobilefe.ui.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.ebookmobilefe.R;
import com.example.ebookmobilefe.databinding.ActivityLoginBinding;
import com.example.ebookmobilefe.viewmodel.LoginViewModel;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLoginBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        LoginViewModel viewModel = new LoginViewModel();
        binding.setLoginViewModel(viewModel);
    }
}