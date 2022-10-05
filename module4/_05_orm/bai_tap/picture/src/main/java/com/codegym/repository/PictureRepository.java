package com.codegym.repository;

import com.codegym.model.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PictureRepository extends JpaRepository<Picture, Integer> {
}
