package com.example.ss14_examination.repository;

import com.example.ss14_examination.modal.Category;

import java.util.List;

public interface CategoryRepository {
    List<Category> selectAllCategories();
}
