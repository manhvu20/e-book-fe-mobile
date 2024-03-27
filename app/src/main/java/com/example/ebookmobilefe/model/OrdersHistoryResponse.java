package com.example.ebookmobilefe.model;

import java.util.List;

public class OrdersHistoryResponse {
    private PaymentDetails paymentDetail;
    private List<OrderItems> listOrderItems;

    public OrdersHistoryResponse() {
    }

    public PaymentDetails getPaymentDetail() {
        return paymentDetail;
    }

    public void setPaymentDetail(PaymentDetails paymentDetail) {
        this.paymentDetail = paymentDetail;
    }

    public List<OrderItems> getListOrderItems() {
        return listOrderItems;
    }

    public void setListOrderItems(List<OrderItems> listOrderItems) {
        this.listOrderItems = listOrderItems;
    }
}
