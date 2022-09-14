package com.example.exam2.repository.impl;

import com.example.exam2.model.Book;
import com.example.exam2.repository.BookRepository;
import com.example.exam2.repository.connect.MySqlConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookRepositoryImpl implements BookRepository {
    private final String SELECT_ALL_BOOKS = "select * from book;";

    @Override
    public List<Book> selectAllBooks() {
        Connection connection = MySqlConnect.getConnectDB();
        List<Book> bookList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOOKS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("book_id");
                String name = resultSet.getString("book_name");
                int amount = resultSet.getInt("amount");
                Book book = new Book(id, name, amount);
                bookList.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookList;
    }
}
