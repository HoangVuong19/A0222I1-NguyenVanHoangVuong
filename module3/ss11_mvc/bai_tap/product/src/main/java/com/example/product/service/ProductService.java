package com.example.product.service;

import com.example.product.model.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {
    List<Product> getAllProducts();

    Map<String, String> saveProduct(Product product);

    Product findProductById(int id);

    void updateProduct(int id, Product product);

    void deleteProduct(int id);
}
