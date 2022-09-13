package com.example.ss14_examination.repository.impl;

import com.example.ss14_examination.modal.Category;
import com.example.ss14_examination.repository.CategoryRepository;
import com.example.ss14_examination.repository.connect.MySqlConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepositoryImpl implements CategoryRepository {
    private final String SELECT_ALL_CATEGORIES = "select * from category;";

    @Override
    public List<Category> selectAllCategories() {
        Connection connection = MySqlConnect.getConnectDB();
        List<Category> categoryList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CATEGORIES);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("category_name");
                Category category = new Category(id, name);
                categoryList.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryList;
    }
}
