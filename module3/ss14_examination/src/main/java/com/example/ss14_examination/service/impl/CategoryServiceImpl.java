package com.example.ss14_examination.service.impl;

import com.example.ss14_examination.modal.Category;
import com.example.ss14_examination.repository.CategoryRepository;
import com.example.ss14_examination.repository.impl.CategoryRepositoryImpl;
import com.example.ss14_examination.service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    CategoryRepository categoryRepository = new CategoryRepositoryImpl();

    @Override
    public List<Category> readAllCategories() {
        return categoryRepository.selectAllCategories();
    }
}
