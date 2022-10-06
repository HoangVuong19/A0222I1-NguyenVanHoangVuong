package com.codegym.service.impl;

import com.codegym.model.Blog;
import com.codegym.repository.IBlogRepository;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {

    @Autowired
    IBlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAllBlog();
    }

    @Override
    public void save(Blog blog) {
        blogRepository.createNewBlog(blog.getAuthor(),blog.getBlogDescription(),blog.getBlogName(), blog.getContent(), blog.getCreateDay(),1);
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.getBlogById(id);
    }

    @Override
    public void remove(Long id) {
        blogRepository.deleteBlog(id);
    }

    @Override
    public void update(Blog blog) {
        blogRepository.updateBlog(blog.getAuthor(), blog.getContent(), blog.getCreateDay(),
                blog.getBlogDescription(), blog.getBlogName(), blog.getId());
    }
}
