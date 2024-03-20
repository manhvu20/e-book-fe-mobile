package com.example.ebookmobilefe.model;

import java.util.List;

public class ListBookResponse {
    private String status;
    private int code;
    private String message;
    private List<Book> data;

    public ListBookResponse(String status, int code, String message, List<Book> data) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public List<Book> getData() {
        return data;
    }
}
