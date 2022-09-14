package com.example.exam2.repository.impl;

import com.example.exam2.model.Customer;
import com.example.exam2.repository.CustomerRepository;
import com.example.exam2.repository.connect.MySqlConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {
    private final String SELECT_ALL_CUSTOMERS = "select * from customer;";
    private final String INSERT_CUSTOMER = "insert into customer(customer_name, phone, email, address) value (?, ?, ?, ?);";

    @Override
    public List<Customer> selectAllCustomers() {
        Connection connection = MySqlConnect.getConnectDB();
        List<Customer> customerList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMERS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("customer_id");
                String name = resultSet.getString("customer_name");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                Customer customer = new Customer(id, name, phone, email, address);
                customerList.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    @Override
    public void insertCustomer(Customer customer) {
        Connection connection = MySqlConnect.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER);
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getPhone());
            preparedStatement.setString(3, customer.getEmail());
            preparedStatement.setString(4, customer.getAddress());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
