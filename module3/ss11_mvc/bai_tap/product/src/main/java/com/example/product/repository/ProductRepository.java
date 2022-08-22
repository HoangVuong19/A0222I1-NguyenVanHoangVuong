package com.example.product.repository;

import com.example.product.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private static final List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "Mac air 2020", 1200, "laptop", "Apple"));
        productList.add(new Product(2, "Mac air 2017", 1000, "laptop", "Apple"));
        productList.add(new Product(3, "Mac air 2015", 900, "laptop", "Apple"));
        productList.add(new Product(4, "Mac air 2021", 1400, "laptop", "Apple"));
        productList.add(new Product(5, "Mac pro 2022", 2000, "laptop", "Apple"));
    }

    public List<Product> findAll(){
        return productList;
    }

    public void add(Product product){
        productList.add(product);
    }

    public Product findById(int id){
        return productList.get(id);
    }

    public void update(int id, Product product){
        productList.set(id, product);
    }

    public void delete(int id){
        productList.remove(id);
    }
}
