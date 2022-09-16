package com.example.ss14_examination.service;

import com.example.ss14_examination.modal.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {
    List<Product> readAllProducts();

    Map<String, String> addProduct(Product product);

    Product findProductById(int id);

    boolean updateProduct(Product product);

    boolean deleteProductById(int id);

    List<Product> searchByName(String character);
}
