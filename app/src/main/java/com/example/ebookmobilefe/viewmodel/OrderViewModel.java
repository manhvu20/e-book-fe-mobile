package com.example.ebookmobilefe.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.ebookmobilefe.model.OrdersHistoryResponse;
import com.example.ebookmobilefe.repository.OrderRepository;

public class OrderViewModel extends ViewModel {
    private OrderRepository orderRepository;
    private MutableLiveData<OrdersHistoryResponse> orderHistoryLiveData = new MutableLiveData<>();
    private MutableLiveData<String> errorLiveData = new MutableLiveData<>();

    public OrderViewModel() {
        orderRepository = new OrderRepository();
    }

    public void getOrderHistory(int pageNum) {
        orderRepository.getOrdersHistory(pageNum, new OrderRepository.OrderHistoryCallback() {
            @Override
            public void onOrderHistoryReceived(OrdersHistoryResponse orderHistoryResponse) {
                orderHistoryLiveData.postValue(orderHistoryResponse);
            }

            @Override
            public void onOrderHistoryError(String errorMessage) {
                errorLiveData.postValue(errorMessage);
            }
        });
    }

    public void searchOrderHistory(String searchQuery) {
        orderRepository.searchOrderHistory(searchQuery, new OrderRepository.OrderHistoryCallback() {
            @Override
            public void onOrderHistoryReceived(OrdersHistoryResponse orderHistoryResponse) {
                orderHistoryLiveData.postValue(orderHistoryResponse);
            }

            @Override
            public void onOrderHistoryError(String errorMessage) {
                errorLiveData.postValue(errorMessage);
            }
        });
    }

    public LiveData<OrdersHistoryResponse> getOrderHistoryLiveData() {
        return orderHistoryLiveData;
    }

    public LiveData<String> getErrorLiveData() {
        return errorLiveData;
    }
}
