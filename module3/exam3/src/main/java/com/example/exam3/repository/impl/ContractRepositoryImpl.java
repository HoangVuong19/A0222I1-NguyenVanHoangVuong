package com.example.exam3.repository.impl;

import com.example.exam3.model.Contract;
import com.example.exam3.repository.ContractRepository;
import com.example.exam3.repository.connect.MySqlConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContractRepositoryImpl implements ContractRepository {
    private final String SELECT_ALL_CONTRACTS = "select * from contract order by `area`;";
    private final String INSERT = "insert into contract(plant_id, `area`, `status`, floor, plant_type, price, start_date, end_date) value (?, ?, ?, ?, ?, ?, ?, ?);";
    private final String DELETE_BY_ID = "delete from contract where id = ?;";
    private final String SEARCH_BY_TYPE = "select * from contract c where c.plant_type like concat('%',?,'%');";

    @Override
    public List<Contract> selectAllContracts() {
        Connection connection = MySqlConnect.getConnectDB();
        List<Contract> contractList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CONTRACTS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String plantId = resultSet.getString("plant_id");
                int area = resultSet.getInt("area");
                String status = resultSet.getString("status");
                int floor = resultSet.getInt("floor");
                String plantType = resultSet.getString("plant_type");
                double price = resultSet.getDouble("price");
                Date startDate = resultSet.getDate("start_date");
                Date endDate = resultSet.getDate("end_date");
                Contract contract = new Contract(id, plantId, area, status, floor, plantType, price, startDate, endDate);
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
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1, contract.getPlantId());
            preparedStatement.setInt(2, contract.getArea());
            preparedStatement.setString(3, contract.getStatus());
            preparedStatement.setInt(4, contract.getFloor());
            preparedStatement.setString(5, contract.getPlantType());
            preparedStatement.setDouble(6, contract.getPrice());
            preparedStatement.setDate(7, contract.getStartDate());
            preparedStatement.setDate(8, contract.getEndDate());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean deleteContractById(int id) {
        Connection connection = MySqlConnect.getConnectDB();
        boolean rowDelete = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID);
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
    public List<Contract> searchContractByType(String type) {
        Connection connection = MySqlConnect.getConnectDB();
        List<Contract> contractList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BY_TYPE);
            preparedStatement.setString(1, type);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String plantId = resultSet.getString("plant_id");
                int area = resultSet.getInt("area");
                String status = resultSet.getString("status");
                int floor = resultSet.getInt("floor");
                String plantType = resultSet.getString("plant_type");
                double price = resultSet.getDouble("price");
                Date startDate = resultSet.getDate("start_date");
                Date endDate = resultSet.getDate("end_date");
                Contract contract = new Contract(id, plantId, area, status, floor, plantType, price, startDate, endDate);
                contractList.add(contract);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contractList;
    }
}
