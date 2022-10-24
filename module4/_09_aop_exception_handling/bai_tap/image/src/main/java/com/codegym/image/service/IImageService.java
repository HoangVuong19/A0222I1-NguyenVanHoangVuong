package com.codegym.image.service;

import com.codegym.image.model.Image;

import java.util.List;

public interface IImageService {
    List<Image> findAll();

    List<Image> findByName(String name);

    void save(Image e);

    void delete(Image e);

    List<Image> findById(Integer id);
}
