package com.example.ebookmobilefe.viewmodel;

import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.ebookmobilefe.model.Book;
import com.example.ebookmobilefe.model.ListBookResponse;
import com.example.ebookmobilefe.repository.BookRepository;

public class ListBookViewModel extends ViewModel {
    private MutableLiveData<ListBookResponse> listBookResult = new MutableLiveData<>();
    private BookRepository bookRepository = new BookRepository();
    public LiveData<ListBookResponse> getListBookResult() {
        return listBookResult;
    }
    public final ObservableField<String> Title = new ObservableField<>();
    public final ObservableField<String> Author = new ObservableField<>();
    public final ObservableField<String> Desc = new ObservableField<>();
    public final ObservableField<String> Price = new ObservableField<>();
    public Book book;


    public ListBookViewModel() {
        Title.set(book.getTitle());
        Author.set(book.getAuthorID());
        Desc.set(book.getDesc());
        Price.set(book.getPrice().toString());
    }
    public void getAllBooks() {
        LiveData<ListBookResponse> listBookRepo = bookRepository.getAllBook();
        listBookRepo.observeForever(listBookResult::setValue);
        listBookResult.setValue(listBookRepo.getValue());
    }
}

