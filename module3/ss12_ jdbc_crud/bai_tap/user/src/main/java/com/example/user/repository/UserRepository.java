package com.example.user.repository;

import com.example.user.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {
    private final String SELECT_ALL = "SELECT * FROM demo.users;";
    private final String INSERT = "insert into users(`name`, email, country) value (?, ?, ?);";
    private final String SELECT_BY_ID = "select * from users where id = ?;";
    private final String UPDATE_BY_ID = "update users set `name` = ?, email = ?, country = ? where id = ?;";
    private final String DELETE_BY_ID = "delete from users where id = ?;";

    @Override
    public List<User> selectAllUsers() {
        List<User> userList = new ArrayList<>();
        Connection connection = MySqlConnect.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                User user = new User(id, name, email, country);
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public void insertUser(User user) {
        Connection connection = MySqlConnect.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User selectUser(int id) {
        User user = null;
        Connection connection = MySqlConnect.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                user = new User(id, name, email, country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean updateUser(User user) {
        boolean rowUpdate = false;
        Connection connection = MySqlConnect.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            preparedStatement.setInt(4, user.getId());
            if (preparedStatement.executeUpdate() > 0) {
                rowUpdate = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdate;
    }

    @Override
    public boolean deleteUser(int id) {
        boolean rowDelete = false;
        Connection connection = MySqlConnect.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID);
            preparedStatement.setInt(1, id);
            if (preparedStatement.executeUpdate() > 0){
                rowDelete = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDelete;
    }
}
