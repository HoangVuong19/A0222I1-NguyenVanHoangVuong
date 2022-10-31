package com.codegym.cart.service.impl;

import com.codegym.cart.model.Product;
import com.codegym.cart.repos.IProductRepository;
import com.codegym.cart.service.IProductService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    IProductRepository productRepository;

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @SneakyThrows
    @Override
    public Product findById(Long id) {
        Optional<Product> produce = productRepository.findById(id);
        if (produce.isPresent()) return produce.get();
        throw new Exception("Not Found any produce with id " + id);
    }
}
