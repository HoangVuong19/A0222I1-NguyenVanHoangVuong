package com.codegym.product.service;

import com.codegym.product.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IProductService {

    Page<Product> paging(String search, Pageable pageable);

    void save(Product product);

    Product findById(Long id);

    void deleteById(Long id);
}
