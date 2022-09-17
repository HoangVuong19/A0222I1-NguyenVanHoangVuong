package com.example.ss14_examination.service.impl;

import com.example.ss14_examination.modal.Product;
import com.example.ss14_examination.repository.ProductRepository;
import com.example.ss14_examination.repository.impl.ProductRepositoryImpl;
import com.example.ss14_examination.service.ProductService;
import com.example.ss14_examination.util.Validation;

import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    ProductRepository productRepository = new ProductRepositoryImpl();

    @Override
    public List<Product> readAllProducts() {
        return productRepository.selectAllProducts();
    }

    @Override
    public Map<String, String> addProduct(Product product) {
        Map<String, String> map = Validation.checkValidAdd(product);
        if (map.isEmpty()) {
            productRepository.insertProduct(product);
        }
        return map;
    }

    @Override
    public Product findProductById(int id) {
        return productRepository.selectProductById(id);
    }

    @Override
    public boolean updateProduct(Product product) {
        return productRepository.updateProduct(product);
    }

    @Override
    public boolean deleteProductById(int id) {
        return productRepository.deleteProductById(id);
    }

    @Override
    public List<Product> searchByName(String character) {
        return productRepository.searchProduct(character);
    }
}
