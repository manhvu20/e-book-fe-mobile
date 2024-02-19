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
        setContentView(R.layout.activity_login);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        viewModel = new ViewModelProvider(this)
                .get(LoginViewModel.class);

        // Set the ViewModel to the binding
        binding.setLoginViewModel(viewModel);

        viewModel.getNavigateToMain().observe(this, navigate -> {
            if (Boolean.TRUE.equals(navigate)) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
