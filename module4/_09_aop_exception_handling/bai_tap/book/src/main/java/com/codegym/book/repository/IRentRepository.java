package com.codegym.book.repository;

import com.codegym.book.models.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRentRepository extends JpaRepository<Rent, Integer> {
    Rent findAllById(Integer id);
}
