package com.example.exam2.model;

public class Contract {
    private int id;
    private String date;
    private String status;
    private int rentAmount;
    private int bookId;
    private int customerId;

    public Contract() {
    }

    public Contract(int id, String date, String status, int rent_amount, int book_id, int customer_id) {
        this.id = id;
        this.date = date;
        this.status = status;
        this.rentAmount = rent_amount;
        this.bookId = book_id;
        this.customerId = customer_id;
    }

    public Contract(String date, String status, int rent_amount, int book_id, int customer_id) {
        this.date = date;
        this.status = status;
        this.rentAmount = rent_amount;
        this.bookId = book_id;
        this.customerId = customer_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getRentAmount() {
        return rentAmount;
    }

    public void setRentAmount(int rentAmount) {
        this.rentAmount = rentAmount;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}
