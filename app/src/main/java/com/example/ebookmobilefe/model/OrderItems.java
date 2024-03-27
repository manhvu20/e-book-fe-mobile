package com.example.ebookmobilefe.model;

import java.security.Timestamp;

public class OrderItems {
    private String orderID;
    private String bookID;
    private Timestamp createdAt;
    private Timestamp modifiedAt;
    private Timestamp deletedAt;

    public OrderItems(){

    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(Timestamp modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public Timestamp getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Timestamp deletedAt) {
        this.deletedAt = deletedAt;
    }

    @Override
    public String toString() {
        return "OrderItems{" +
                "orderID='" + orderID + '\'' +
                ", bookID='" + bookID + '\'' +
                ", createdAt=" + createdAt +
                ", modifiedAt=" + modifiedAt +
                ", deletedAt=" + deletedAt +
                '}';
    }
}
