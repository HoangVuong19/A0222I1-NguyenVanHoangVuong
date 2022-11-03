package com.example.demo.service;

import com.example.demo.models.Blog;

import java.util.Optional;

public interface IBlogService {
    Iterable<Blog> findAll();

    Iterable<Blog> findAllByCategory(Integer id);

    Optional<Blog> findById(Integer id);
}
