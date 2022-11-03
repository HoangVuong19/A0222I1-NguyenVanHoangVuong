package com.example.demo.repository;

import com.example.demo.models.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {

    @Query(value = "select * from blog b where b.category_id = ?", nativeQuery = true)
    Iterable<Blog> findAllByCategory(Integer categoryId);
}
