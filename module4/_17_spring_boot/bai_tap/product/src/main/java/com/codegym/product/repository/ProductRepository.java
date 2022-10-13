package com.codegym.product.repository;

import com.codegym.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByNameContains(String name);

    @Query(value = "select * from product where manufacturer like %?%", nativeQuery = true)
    List<Product> searchByManufacturer(String manufacturer);
}