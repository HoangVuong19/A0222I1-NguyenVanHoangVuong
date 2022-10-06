package com.codegym.service;

import com.codegym.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    void save(Blog blog);

    Blog findById(Long id);

    void remove(Long id);

    void update(Blog blog);
}
