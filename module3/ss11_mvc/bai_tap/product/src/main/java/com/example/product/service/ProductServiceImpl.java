package com.example.product.service;

import com.example.product.model.Product;
import com.example.product.repository.ProductRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository = new ProductRepository();
    private final List<Product> products = productRepository.findAll();

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Map<String, String> saveProduct(Product product) {
        int id = products.get(products.size() - 1).getId() + 1;
        product.setId(id);

        Map<String, String> map = new HashMap<>();
        if (product.getPrice() < 0){
            map.put("price", "price is not negative");
        }
        if (product.getName().equals("")){
            map.put("name", "name is not null");
        }
        if (product.getDescription().equals("")){
            map.put("description", "description is not null");
        }
        if (product.getManufacture().equals("")){
            map.put("manufacture", "manufacture is not null");
        }
        if (map.isEmpty()){
            productRepository.add(product);
        }
        return map;
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
