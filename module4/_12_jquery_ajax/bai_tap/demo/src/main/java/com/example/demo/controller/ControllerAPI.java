package com.example.demo.controller;

import com.example.demo.models.Blog;
import com.example.demo.models.Category;
import com.example.demo.service.IBlogAPIService;
import com.example.demo.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ControllerAPI {
    @Autowired
    IBlogAPIService service;

    @Autowired
    ICategoryService categoryService;

    @GetMapping("/categoryList")
    public ResponseEntity<Iterable<Category>> getListCategory() {
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/getList")
    public ResponseEntity<Iterable<Blog>> getList(@RequestParam(value = "title", defaultValue = "") String title_search) {
        return new ResponseEntity<>(service.findAllByName(title_search), HttpStatus.OK);
    }

    @GetMapping("/getListByCategoryName")
    public ResponseEntity<Iterable<Blog>> getListByCategoryName(@RequestParam("name_search") String name_search) {
        return new ResponseEntity<>(service.findAllByCategoryName(name_search), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Blog> saveBlog(@RequestBody Blog blog) {
        return new ResponseEntity<>(service.save(blog), HttpStatus.OK);
    }

    @GetMapping("/getListByCategoryId")
    public ResponseEntity<Iterable<Blog>> getListByCategoryId(@RequestParam("id_search") Integer id_search) {
        return new ResponseEntity<>(service.findAllByCategoryId(id_search), HttpStatus.OK);
    }

    @GetMapping("/readInfo/{id}")
    public ResponseEntity<Blog> readInfo(@PathVariable Integer id) {
        Optional<Blog> blog = service.findById(id);
        return blog.map(x -> new ResponseEntity<>(x, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
