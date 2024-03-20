package com.example.ebookmobilefe.model;

import java.security.Timestamp;

public class Book {
    private String bookID;
    private String title;
    private String desc;
    private String image;
    private Integer price;
    private String authorID;
    private String categoryID;
    private Timestamp createdAt;
    private Timestamp modifiedAt;
    private Timestamp deletedAt;

    public Book() {
    }

    public Book(String bookID, String title, String desc, String image, Integer price, String authorID, String categoryID) {
        this.bookID = bookID;
        this.title = title;
        this.desc = desc;
        this.image = image;
        this.price = price;
        this.authorID = authorID;
        this.categoryID = categoryID;
        //this.createdAt = createdAt;
        //this.modifiedAt = modifiedAt;
        //this.deletedAt = deletedAt;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getAuthorID() {
        return authorID;
    }

    public void setAuthorID(String authorID) {
        this.authorID = authorID;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

}


