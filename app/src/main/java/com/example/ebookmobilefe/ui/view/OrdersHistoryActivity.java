package com.example.ebookmobilefe.ui.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ebookmobilefe.R;
import com.example.ebookmobilefe.model.OrdersHistoryResponse;
import com.example.ebookmobilefe.viewmodel.OrderViewModel;

public class OrdersHistoryActivity extends AppCompatActivity {

    private OrderViewModel orderViewModel;
    private EditText searchEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders_history);

        // Khởi tạo OrderViewModel
        orderViewModel = new ViewModelProvider(this).get(OrderViewModel.class);

        // Ánh xạ các view từ layout XML
        TextView titleTextView = findViewById(R.id.textView13);
        searchEditText = findViewById(R.id.editTextText);

        // Lắng nghe sự kiện khi người dùng nhấn phím Enter trên bàn phím
        searchEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    performSearch();
                    return true;
                }
                return false;
            }
        });

        // Quan sát LiveData để cập nhật giao diện khi dữ liệu thay đổi
        orderViewModel.getOrderHistoryLiveData().observe(this, new Observer<OrdersHistoryResponse>() {
            @Override
            public void onChanged(OrdersHistoryResponse orderHistoryResponse) {


            }
        });

        orderViewModel.getErrorLiveData().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String errorMessage) {

                Toast.makeText(OrdersHistoryActivity.this, errorMessage, Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void performSearch() {
        String searchQuery = searchEditText.getText().toString().trim();
        if (!searchQuery.isEmpty()) {
            // Gọi phương thức để lấy dữ liệu dựa trên truy vấn tìm kiếm
            orderViewModel.searchOrderHistory(searchQuery);
        } else {
            // Nếu ô tìm kiếm trống, hiển thị thông báo
            Toast.makeText(this, "Please enter a search query", Toast.LENGTH_SHORT).show();
        }
    }
}