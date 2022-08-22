package com.example.product.service;

import com.example.product.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    boolean saveProduct(Product product);

    Product findProductById(int id);

    void updateProduct(int id, Product product);

    void deleteProduct(int id);
}
