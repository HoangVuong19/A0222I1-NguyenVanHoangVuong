package com.example.demo.controller;

import com.example.demo.models.Blog;
import com.example.demo.models.Category;
import com.example.demo.service.IBlogService;
import com.example.demo.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/categoryList")
    public ResponseEntity<Iterable<Category>> getListCategory() {
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/blogList")
    public ResponseEntity<Iterable<Blog>> getListBlog() {
        return new ResponseEntity<>(blogService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/getListByCategory/{id}")
    public ResponseEntity<Iterable<Blog>> getListByCategory(@PathVariable Integer id) {
        return new ResponseEntity<>(blogService.findAllByCategory(id), HttpStatus.OK);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<Optional<Blog>> readInfo(@PathVariable Integer id) {
        Optional<Blog> blog = blogService.findById(id);
        if (!blog.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog,HttpStatus.OK);
    }
}
