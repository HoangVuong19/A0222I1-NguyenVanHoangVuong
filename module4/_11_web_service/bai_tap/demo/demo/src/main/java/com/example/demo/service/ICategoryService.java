package com.example.demo.service;

import com.example.demo.models.Category;

public interface ICategoryService {
    Iterable<Category> findAll();
}
