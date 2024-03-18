package com.example.ebookmobilefe.ui.view;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.ebookmobilefe.R;
import android.content.Intent;

public class Add_Book extends AppCompatActivity {

  Button btBack;
    private Spinner mSpinner;
    private static final int REQUEST_FILE_PICKER = 1;
    private static final int REQUEST_IMAGE_PICKER = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_book);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btn=findViewById(R.id.btSave);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Add_Book.this, "Bạn đã lưu thành công", Toast.LENGTH_SHORT).show();
            }
        });

        btBack=findViewById(R.id.btBack);
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //thoát
               finish();
            }
        });


        mSpinner= findViewById(R.id.spCategory);
        String[] Category={ " Ngôn tình", " Trinh Thám ", "Hành Động"};
        ArrayAdapter adapter= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Category);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(adapter);




    }



    public void onClick_btUploadImage(View view) {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.setType("image/*"); // Chỉ chấp nhận tệp ảnh
        startActivityForResult(intent, REQUEST_IMAGE_PICKER);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_FILE_PICKER && resultCode == RESULT_OK && data != null) {
            // Xử lý tệp đã chọn
        } else if (requestCode == REQUEST_IMAGE_PICKER && resultCode == RESULT_OK && data != null) {
            // Lấy URI của tệp ảnh đã chọn
            // Uri uri = data.getData();

            // Xử lý URI tại đây (ví dụ: lưu trữ URI trong một biến hoặc thực hiện thao tác khác)
        }
    }


}