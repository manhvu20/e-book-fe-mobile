package com.example.ebookmobilefe.ui.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.ebookmobilefe.R;
import com.example.ebookmobilefe.databinding.ActivityLoginBinding;
import com.example.ebookmobilefe.databinding.ActivityMainBinding;
import com.example.ebookmobilefe.viewmodel.LoginViewModel;

import retrofit2.Retrofit;

public class LoginActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private ActivityLoginBinding binding;
    private LoginViewModel viewModel;

    // Assuming this is in an Activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLoginBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        viewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        binding.setLoginViewModel(viewModel);
        binding.setLifecycleOwner(this);
        viewModel.getLoginResult().observe(this, isSuccess -> {
            if (isSuccess) {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(this, "Login failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
