package com.example.ebookmobilefe.ui.view;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.ebookmobilefe.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class List_Category extends AppCompatActivity {
    private ListView mList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_category);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        mList=findViewById(R.id.ivlist);
        String[] from={"id", "Category"};
        int[] to={ R.id.tvidCategory, R.id.tvCategoryNameList};

        List<HashMap<String,Object>> list =new ArrayList<>();

        HashMap<String,Object> item1= new HashMap<>() ;
        item1.put("id","1");
        item1.put("Category","Ngôn Tình");

        HashMap<String,Object> item2= new HashMap<>() ;
        item2.put("id","2");
        item2.put("Category","Trinh Thám");


        list.add(item1);
        list.add(item2);

        SimpleAdapter adapter =new SimpleAdapter(this,list, R.layout.list_item_category,from, to);
        mList.setAdapter(adapter);
    }
}