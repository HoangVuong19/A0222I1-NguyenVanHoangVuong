package com.example.demo.service;

import com.example.demo.models.Blog;

import java.util.Optional;

public interface IBlogAPIService {
    Iterable<Blog> findAllByName(String name);

    Iterable<Blog> findAllByCategoryName(String name);

    Iterable<Blog> findAllByCategoryId(Integer id_search);

    Optional<Blog> findById(Integer id);

    Blog save(Blog blog);
}
