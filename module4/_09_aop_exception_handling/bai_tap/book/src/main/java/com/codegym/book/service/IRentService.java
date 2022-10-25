package com.codegym.book.service;

import com.codegym.book.models.Rent;

import java.util.List;

public interface IRentService {
    void save(Rent rent);

    List<Rent> findAll();

    Rent findById(Integer id);
}
