package com.example.ebookmobilefe.model;

import java.security.Timestamp;

public class OrderDetails {
    private String userID;
    private float total;
    private String paymentID;
    private String voucherID;
    private Timestamp createdAt;
    private Timestamp modifiedAt;
    private Timestamp deletedAt;

    public OrderDetails(){

    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(String paymentID) {
        this.paymentID = paymentID;
    }

    public String getVoucherID() {
        return voucherID;
    }

    public void setVoucherID(String voucherID) {
        this.voucherID = voucherID;
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
        return "OrderDetails{" +
                "userID='" + userID + '\'' +
                ", total=" + total +
                ", paymentID='" + paymentID + '\'' +
                ", voucherID='" + voucherID + '\'' +
                ", createdAt=" + createdAt +
                ", modifiedAt=" + modifiedAt +
                ", deletedAt=" + deletedAt +
                '}';
    }
}
