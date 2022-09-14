package com.example.exam2.service;

import com.example.exam2.model.Customer;

import java.util.List;
import java.util.Map;

public interface CustomerService {
    List<Customer> readAllCustomers();

    Map<String, String> addCustomer(Customer customer);
}
