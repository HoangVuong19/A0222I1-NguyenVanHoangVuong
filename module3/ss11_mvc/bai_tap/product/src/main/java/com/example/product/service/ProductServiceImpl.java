package com.example.product.service;

import com.example.product.model.Product;
import com.example.product.repository.ProductRepository;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository = new ProductRepository();
    private final List<Product> products = productRepository.findAll();

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public boolean saveProduct(Product product) {
        int id = products.get(products.size() - 1).getId() + 1;
        product.setId(id);
        productRepository.add(product);
        return true;
    }

    @Override
    public Product findProductById(int id) {
        return productRepository.findById(id - 1);
    }

    @Override
    public void updateProduct(int id, Product product) {
        productRepository.update(id - 1, product);
    }

    @Override
    public void deleteProduct(int id) {
        productRepository.delete(id - 1);
    }
}
