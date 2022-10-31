package com.codegym.cart.service;

import com.codegym.cart.model.Product;

public interface IProductService {
    Iterable<Product> findAll();

    Product findById(Long id);
}
