package com.example.exam2.repository;

import com.example.exam2.model.Book;

import java.util.List;

public interface BookRepository {
    List<Book> selectAllBooks();
}
