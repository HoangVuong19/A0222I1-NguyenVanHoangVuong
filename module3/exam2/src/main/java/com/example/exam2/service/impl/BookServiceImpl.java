package com.example.exam2.service.impl;

import com.example.exam2.model.Book;
import com.example.exam2.repository.BookRepository;
import com.example.exam2.repository.impl.BookRepositoryImpl;
import com.example.exam2.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    BookRepository bookRepository = new BookRepositoryImpl();

    @Override
    public List<Book> readAllBooks() {
        return bookRepository.selectAllBooks();
    }
}
