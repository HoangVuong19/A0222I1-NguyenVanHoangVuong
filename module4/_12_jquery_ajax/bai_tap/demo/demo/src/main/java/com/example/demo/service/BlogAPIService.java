package com.example.demo.service;

import com.example.demo.models.Blog;
import com.example.demo.repository.IBlogAPIRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BlogAPIService implements IBlogAPIService {
    @Autowired
    IBlogAPIRepository iBlogAPIRepository;

    @Override
    public Iterable<Blog> findAllByName(String name) {
        return iBlogAPIRepository.findAllByName(name);
    }

    @Override
    public Iterable<Blog> findAllByCategoryName(String name) {
        return iBlogAPIRepository.findAllByCategoryName(name);
    }

    @Override
    public Iterable<Blog> findAllByCategoryId(Integer id_search) {
        return iBlogAPIRepository.findAllByCategoryId(id_search);
    }

    @Override
    public Optional<Blog> findById(Integer id) {
        return iBlogAPIRepository.findById(id);
    }

    @Override
    public Blog save(Blog blog) {
        return iBlogAPIRepository.save(blog);
    }
}
