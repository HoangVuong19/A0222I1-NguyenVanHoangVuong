package com.codegym.image.repository;

import com.codegym.image.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
    @Query(value = "select * from image where id_image = ?", nativeQuery = true)
    List<Image> searchById(Integer id);
}