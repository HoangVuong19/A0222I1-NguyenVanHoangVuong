package com.codegym.image.service.impl;

import com.codegym.image.model.Image;
import com.codegym.image.repository.ImageRepository;
import com.codegym.image.service.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService implements IImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Override
    public List<Image> findAll() {
        return imageRepository.findAll();
    }

    @Override
    public List<Image> findByName(String name) {
        return null;
    }

    @Override
    public void save(Image e) {
        imageRepository.save(e);
    }

    @Override
    public void delete(Image e) {

    }

    @Override
    public List<Image> findById(Integer id) {
        return imageRepository.searchById(id);
    }
}
