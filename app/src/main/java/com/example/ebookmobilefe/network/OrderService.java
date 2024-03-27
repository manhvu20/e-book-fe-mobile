package com.example.ebookmobilefe.network;


import com.example.ebookmobilefe.model.OrdersHistoryResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface OrderService {
    @GET("v1/api/order/shop/order-history")
    Call<OrdersHistoryResponse> getOrderHistory(@Query("pageNum") int pageNum);
}