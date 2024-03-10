package com.example.ebookmobilefe.ui.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.ebookmobilefe.R;
import com.example.ebookmobilefe.databinding.ActivityLoginBinding;
import com.example.ebookmobilefe.databinding.ActivityMainBinding;
import com.example.ebookmobilefe.fragment.AccountFragment;
import com.example.ebookmobilefe.fragment.ForYouFragment;
import com.example.ebookmobilefe.fragment.LibraryFragment;
import com.example.ebookmobilefe.fragment.ShoppingCartFragment;
import com.example.ebookmobilefe.viewmodel.LoginViewModel;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Command tạm thời
        // super.onCreate(savedInstanceState);
        // ActivityLoginBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        // LoginViewModel viewModel = new LoginViewModel();
        // binding.setLoginViewModel(viewModel);

        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new ForYouFragment());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            if (item.getItemId() == R.id.for_you) {
                replaceFragment(new ForYouFragment());
            } else if (item.getItemId() == R.id.library) {
                replaceFragment(new LibraryFragment());
            } else if (item.getItemId() == R.id.shopping_cart) {
                replaceFragment(new ShoppingCartFragment());
            } else if (item.getItemId() == R.id.account) {
                replaceFragment(new AccountFragment());
            }

            return true;
        });

    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }
}