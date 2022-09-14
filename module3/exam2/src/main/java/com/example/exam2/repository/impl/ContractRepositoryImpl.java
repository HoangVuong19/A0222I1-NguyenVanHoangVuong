package com.example.exam2.repository.impl;

import com.example.exam2.model.Contract;
import com.example.exam2.repository.ContractRepository;
import com.example.exam2.repository.connect.MySqlConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContractRepositoryImpl implements ContractRepository {
    private final String SELECT_ALL_CONTRACTS = "select * from contract;";
    private final String INSERT_CONTRACT = "insert into contract(rent_time, `status`, rent_amount, book_id, customer_id) value (?, ?, ?, ?, ?);";
    private final String SELECT_CONTRACT_BY_ID = "select * from contract where id = ?;";
    private final String UPDATE_CONTRACT_BY_ID = "update contract set rent_time = ?, `status` = ?, rent_amount = ?, customer_id = ? where id = ?;";
    private final String DELETE_CONTRACT_BY_ID = "delete from contract where id = ?;";
    private final String SEARCH = "call search_by_book(?);";

    @Override
    public List<Contract> selectAllContracts() {
        Connection connection = MySqlConnect.getConnectDB();
        List<Contract> contractList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CONTRACTS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String date = resultSet.getString("rent_time");
                String status = resultSet.getString("status");
                int rentAmount = resultSet.getInt("rent_amount");
                int bookId = resultSet.getInt("book_id");
                int customerId = resultSet.getInt("customer_id");
                Contract contract = new Contract(id, date, status, rentAmount, bookId, customerId);
                contractList.add(contract);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contractList;
    }

    @Override
    public void insertContract(Contract contract) {
        Connection connection = MySqlConnect.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CONTRACT);
            preparedStatement.setDate(1, Date.valueOf(contract.getDate()));
            preparedStatement.setString(2, contract.getStatus());
            preparedStatement.setInt(3, contract.getRentAmount());
            preparedStatement.setInt(4, contract.getBookId());
            preparedStatement.setInt(5, contract.getCustomerId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Contract selectContractById(int id) {
        Connection connection = MySqlConnect.getConnectDB();
        Contract contract = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CONTRACT_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String date = resultSet.getString("rent_time");
                String status = resultSet.getString("status");
                int rentAmount = resultSet.getInt("rent_amount");
                int bookId = resultSet.getInt("book_id");
                int customerId = resultSet.getInt("customer_id");
                contract = new Contract(id, date, status, rentAmount, bookId, customerId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contract;
    }

    @Override
    public boolean updateContract(Contract contract) {
        Connection connection = MySqlConnect.getConnectDB();
        boolean rowUpdate = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CONTRACT_BY_ID);
            preparedStatement.setString(1, contract.getDate());
            preparedStatement.setString(2, contract.getStatus());
            preparedStatement.setInt(3, contract.getRentAmount());
            preparedStatement.setInt(4, contract.getCustomerId());
            preparedStatement.setInt(5, contract.getId());
            if (preparedStatement.executeUpdate() > 0) {
                rowUpdate = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdate;
    }

    @Override
    public boolean deleteContractById(int id) {
        Connection connection = MySqlConnect.getConnectDB();
        boolean rowDelete = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CONTRACT_BY_ID);
            preparedStatement.setInt(1, id);
            if (preparedStatement.executeUpdate() > 0) {
                rowDelete = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDelete;
    }

    @Override
    public List<Contract> searchContract(String character) {
        Connection connection = MySqlConnect.getConnectDB();
        List<Contract> contractList = new ArrayList<>();
        try {
            CallableStatement callableStatement = connection.prepareCall(SEARCH);
            callableStatement.setString(1, character);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String date = resultSet.getString("rent_time");
                String status = resultSet.getString("status");
                int rentAmount = resultSet.getInt("rent_amount");
                int bookId = resultSet.getInt("book_id");
                int customerId = resultSet.getInt("customer_id");
                Contract contract = new Contract(id, date, status, rentAmount, bookId, customerId);
                contractList.add(contract);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contractList;
    }
}
