package com.example.exam2.repository;

import com.example.exam2.model.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> selectAllCustomers();

    void insertCustomer(Customer customer);
}
