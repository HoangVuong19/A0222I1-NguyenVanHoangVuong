package com.codegym.book.service;

import com.codegym.book.models.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();

    Book findById(Integer id);

    void save(Book book);
}
