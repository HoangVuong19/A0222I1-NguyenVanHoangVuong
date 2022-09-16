package com.example.ss14_examination.service.impl;

import com.example.ss14_examination.modal.Product;
import com.example.ss14_examination.repository.ProductRepository;
import com.example.ss14_examination.repository.impl.ProductRepositoryImpl;
import com.example.ss14_examination.service.ProductService;

import java.util.HashMap;
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
        Map<String, String> map = new HashMap<>();
        if (product.getName().equals("")) {
            map.put("name", "name is not null");
        }
        if (product.getPrice() == -1) {
            map.put("price", "price is not null");
        } else if (product.getPrice() < 0) {
            map.put("price", "price must not have negative value");
        }
        if (product.getQuantity() == -1) {
            map.put("quantity", "quantity is not null");
        } else if (product.getQuantity() < 0) {
            map.put("quantity", "quantity must not have negative value");
        }
        if (product.getColor().equals("")) {
            map.put("color", "color is not null");
        }
        if (product.getDescription().equals("")) {
            map.put("description", "description is not null");
        }
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
