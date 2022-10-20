package com.codegym.product.repository;

import com.codegym.product.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findAllByNameContains(String name, Pageable pageable);

//    @Query(value = "select * from product where manufacturer like %?%", nativeQuery = true)
//    Page<Product> searchByManufacturer(String manufacturer, Pageable pageable);
}