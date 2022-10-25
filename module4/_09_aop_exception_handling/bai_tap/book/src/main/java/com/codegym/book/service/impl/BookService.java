package com.codegym.book.service.impl;

import com.codegym.book.models.Book;
import com.codegym.book.repository.IBookRepository;
import com.codegym.book.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements IBookService {
    @Autowired
    IBookRepository repository;

    @Override
    public List<Book> findAll() {
        return repository.findAll();
    }

    @Override
    public Book findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void save(Book book) {
        repository.save(book);
    }
}
