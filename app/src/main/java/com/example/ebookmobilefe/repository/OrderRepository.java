package com.example.ebookmobilefe.repository;

import androidx.annotation.NonNull;

import com.example.ebookmobilefe.model.OrdersHistoryResponse;
import com.example.ebookmobilefe.network.OrderService;
import com.example.ebookmobilefe.network.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderRepository {
    private final OrderService orderService;

    public OrderRepository() {
        this.orderService = RetrofitInstance.getRetrofitInstance().create(OrderService.class);
    }

    public void getOrdersHistory(int pageNum, final OrderHistoryCallback callback) {
        Call<OrdersHistoryResponse> call = orderService.getOrderHistory(pageNum);
        call.enqueue(new Callback<OrdersHistoryResponse>() {
            @Override
            public void onResponse(@NonNull Call<OrdersHistoryResponse> call, @NonNull Response<OrdersHistoryResponse> response) {
                if (response.isSuccessful()) {
                    OrdersHistoryResponse ordersHistoryResponse = response.body();
                    if (ordersHistoryResponse != null) {
                        callback.onOrderHistoryReceived(ordersHistoryResponse);
                    } else {
                        callback.onOrderHistoryError("Response body is null");
                    }
                } else {
                    callback.onOrderHistoryError("Failed to get order history: " + response.message());
                }
            }

            @Override
            public void onFailure(@NonNull Call<OrdersHistoryResponse> call, @NonNull Throwable t) {
                callback.onOrderHistoryError("Failed to get order history: " + t.getMessage());
            }
        });
    }

    /*public void searchOrderHistory(String searchQuery, final OrderHistoryCallback callback) {
        getOrderHistory(1, new OrderHistoryCallback() {
            @Override
            public void onOrderHistoryReceived(OrdersHistoryResponse orderHistoryResponse) {

                List<OrderItems> filteredOrders = new ArrayList<>();

                for (OrderItems order : orderHistoryResponse.getData()) {
                    if (order.getOrderID().contains(searchQuery)) {
                        filteredOrders.add(order);
                    }
                }

                OrdersHistoryResponse filteredResponse = new OrdersHistoryResponse();
                filteredResponse.setData(filteredOrders);

                callback.onOrderHistoryReceived(filteredResponse);
            }

            @Override
            public void onOrderHistoryError(String errorMessage) {
                callback.onOrderHistoryError(errorMessage);
            }
        });
    }*/

    public interface OrderHistoryCallback {
        void onOrderHistoryReceived(OrdersHistoryResponse orderHistoryResponse);
        void onOrderHistoryError(String errorMessage);
    }
}

