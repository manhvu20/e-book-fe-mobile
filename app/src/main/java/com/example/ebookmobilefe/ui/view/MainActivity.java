package com.example.ebookmobilefe.ui.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ebookmobilefe.R;
import com.example.ebookmobilefe.ui.adapter.MyTestAdapter;
import com.example.ebookmobilefe.viewmodel.MainViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private MainViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        viewModel.getItems().observe(this, items -> {
            // Update the UI
            MyTestAdapter adapter = new MyTestAdapter(items);
            recyclerView.setAdapter(adapter);
        });
    }
}