package com.example.ebookmobilefe.ui.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.ebookmobilefe.R;
import com.example.ebookmobilefe.generated.callback.OnClickListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class List_Ebook extends AppCompatActivity {

    ImageButton ibtAdd;
    private ListView mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_ebook);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        ibtAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Khai báo Intent để chuyển từ List_Ebook sang Add_Ebook
                Intent intent = new Intent(List_Ebook.this,Add_Book.class);
                startActivity(intent);
            }
        });

        mList=findViewById(R.id.ivlist);
        String[] from={"Name", "Author","image" };
        int[] to={R.id.tvName, R.id.tvAuthorBook, R.id.ivimage};

        List<HashMap<String,Object>> list =new ArrayList<>();

        HashMap<String,Object> item1= new HashMap<>() ;
        item1.put("Name","Đắc nhân tâm");
        item1.put("Author","Dale Carnegie");
        item1.put("image",R.drawable.dacnhantam);

        HashMap<String,Object> item2= new HashMap<>() ;
        item2.put("Name","Đắc nhân tâm");
        item2.put("Author","Dale Carnegie");
        item2.put("image",R.drawable.dacnhantam);

        list.add(item1);
        list.add(item2);

        SimpleAdapter adapter =new SimpleAdapter(this,list, R.layout.list_item_ebook,from, to);
         mList.setAdapter(adapter);



    }
}