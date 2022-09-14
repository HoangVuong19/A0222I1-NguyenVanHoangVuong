package com.example.exam2.service.impl;

import com.example.exam2.config.Validation;
import com.example.exam2.model.Customer;
import com.example.exam2.repository.CustomerRepository;
import com.example.exam2.repository.impl.CustomerRepositoryImpl;
import com.example.exam2.service.CustomerService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceImpl implements CustomerService {
    CustomerRepository customerRepository = new CustomerRepositoryImpl();

    @Override
    public List<Customer> readAllCustomers() {
        return customerRepository.selectAllCustomers();
    }

    @Override
    public Map<String, String> addCustomer(Customer customer) {
        Map<String, String> map = new HashMap<>();
        if (customer.getName().equals("")){
            map.put("name", "name is not null");
        }
        if (customer.getPhone().equals("")){
            map.put("phone", "phone is not null");
        } else if(!Validation.checkPhone(customer.getPhone())){
            map.put("phone","Format is not correct");
        }
        if (customer.getEmail().equals("")){
            map.put("email", "email is not null");
        } else if(!Validation.checkEmail(customer.getEmail())){
            map.put("email","Format is not correct");
        }
        if (customer.getAddress().equals("")){
            map.put("address", "address is not null");
        }
        if (map.isEmpty()){
            customerRepository.insertCustomer(customer);
        }
        return map;
    }
}
