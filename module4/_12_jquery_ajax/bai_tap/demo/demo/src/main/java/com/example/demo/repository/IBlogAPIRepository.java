package com.example.demo.repository;

import com.example.demo.models.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogAPIRepository extends JpaRepository<Blog, Integer> {

    @Query("select c from Blog c where c.name like concat('%',:name,'%') ")
    Iterable<Blog> findAllByName(@Param("name") String name);

//    @Query(value = "select * from blog where category_id = :id_search", nativeQuery = true)
    @Query("select b from Blog b where b.category.name = :name_search")
    Iterable<Blog> findAllByCategoryName(@Param("name_search") String name_search);

    @Query("select b from Blog b where b.category.id = :id_search")
    Iterable<Blog> findAllByCategoryId(@Param("id_search") Integer id_search);

}
