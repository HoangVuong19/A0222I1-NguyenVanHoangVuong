package com.example.ss14_examination.repository;

import com.example.ss14_examination.modal.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> selectAllProducts();

    void insertProduct(Product product);

    Product selectProductById(int id);

    boolean updateProduct(Product product);

    boolean deleteProductById(int id);

    List<Product> searchProduct(String character);
}
