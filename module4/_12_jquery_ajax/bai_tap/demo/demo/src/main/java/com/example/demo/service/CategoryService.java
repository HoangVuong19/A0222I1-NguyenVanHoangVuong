package com.example.demo.service;

import com.example.demo.models.Category;
import com.example.demo.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService implements ICategoryService{
    @Autowired
    ICategoryRepository repository;

    @Override
    public Iterable<Category> findAll() {
        return repository.findAll();
    }
}
