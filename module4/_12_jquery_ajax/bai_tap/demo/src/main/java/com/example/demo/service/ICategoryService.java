package com.example.demo.service;

import com.example.demo.models.Category;

import java.util.List;

public interface ICategoryService {
    Iterable<Category> findAll();
}
