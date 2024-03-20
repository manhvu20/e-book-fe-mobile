package com.example.ebookmobilefe.ui.view;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ebookmobilefe.R;
import com.example.ebookmobilefe.databinding.ActivityListBookBinding;
import com.example.ebookmobilefe.model.Book;
import com.example.ebookmobilefe.ui.adapter.ListBookAdapter;
import com.example.ebookmobilefe.viewmodel.ListBookViewModel;

import java.util.List;

public class ListBookActivity extends AppCompatActivity {


    TextView tvHeader;
    RecyclerView rvListBook;
    private List<Book> listBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_book);

        ActivityListBookBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_list_book);
        ListBookViewModel viewModel = new ListBookViewModel();
        binding.setListBookViewModel(viewModel);

        rvListBook = findViewById(R.id.rvListBook);
        rvListBook.setLayoutManager(new LinearLayoutManager(this));
        rvListBook.setHasFixedSize(true);

        viewModel = new ViewModelProvider(this).get(ListBookViewModel.class);
        viewModel.getListBookResult().observe(this, (x)->{
            rvListBook.setAdapter(new ListBookAdapter(x.getData()));
        });
    }

    /*
    private void setEvent() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvListBook.setLayoutManager(linearLayoutManager);

        DividerItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rvListBook.addItemDecoration(itemDecoration);

        listBook = new ArrayList<>();
    }

    private void setControl() {
        rvListBook = findViewById(R.id.rvListBook);
        tvHeader = findViewById(R.id.tvHeader);
    }

    private void getAllBook() {
        ListBookService.getAllBook().enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                listBook = response.body();
                ListBookAdapter listBookAdapter = new ListBookAdapter(listBook);
                rvListBook.setAdapter(listBookAdapter);
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {
                Toast.makeText(ListBookActivity.this, "onFailure", Toast.LENGTH_SHORT).show();
            }
        });
    }
    */

}