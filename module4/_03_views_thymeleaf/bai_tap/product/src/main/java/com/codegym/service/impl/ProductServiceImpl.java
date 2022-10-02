package com.codegym.service.impl;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements IProductService {
    private static final Map<Integer, Product> productList = new HashMap<>();

    static {
        productList.put(1, new Product(1, "Iphone 14", 1800.0, "new phone in 2022", "Apple"));
        productList.put(2,new Product(2, "Samsung A10", 1000.0, "new phone in 2022", "Samsumg"));
        productList.put(3,new Product(3, "Oppo A123", 988.0, "new phone in 2022", "Oppo"));
        productList.put(4,new Product(4, "Google Pixel", 2300.0, "new phone in 2022", "Google"));
        productList.put(5,new Product(5, "LG 1234", 555.0, "new phone in 2022", "LG"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productList.values());
    }

    @Override
    public void save(Product product) {
        productList.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return productList.get(id);
    }

    @Override
    public void update(int id, Product product) {
        productList.put(id, product);
    }

    @Override
    public void delete(int id) {
        productList.remove(id);
    }
}
