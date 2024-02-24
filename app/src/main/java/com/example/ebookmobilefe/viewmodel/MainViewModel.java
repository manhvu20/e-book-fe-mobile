package com.example.ebookmobilefe.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.ebookmobilefe.R;
import com.example.ebookmobilefe.model.TestItem;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends AndroidViewModel {
    private MutableLiveData<List<TestItem>> items;

    public MainViewModel(@NonNull Application application) {
        super(application);
        items = new MutableLiveData<>();
        // Dummy data initialization
        List<TestItem> itemList = new ArrayList<>();
        itemList.add(new TestItem("Fruits","Fresh Fruits from the Garden"));
        itemList.add(new TestItem("Vegetables","Delicious Vegetables "));
        items.setValue(itemList);
    }

    public LiveData<List<TestItem>> getItems() {
        return items;
    }

    // Method to add an item, can be called from the UI to update data
    public void addItem(TestItem item) {
        List<TestItem> currentItems = items.getValue();
        if (currentItems != null) {
            currentItems.add(item);
            items.setValue(currentItems);
        }
    }
}
