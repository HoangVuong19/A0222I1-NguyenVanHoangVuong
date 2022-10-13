package com.codegym.product.service;

import com.codegym.product.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    Page<Product> paging(Pageable pageable);

    void save(Product product);

    Product findById(Long id);

    void deleteById(Long id);

    List<Product> searchByName(String searchName);

    List<Product> searchByManufacturer(String element);
}
