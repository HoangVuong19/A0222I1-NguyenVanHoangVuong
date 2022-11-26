package com.example.demo.repository;

import com.example.demo.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query(value = "select * from student order by id asc",nativeQuery = true)
    List<Student> findAllStudent();

    @Query(value = "select * from student where student.`name` like concat('%',:name,'%')", nativeQuery = true)
    Page<Student> findAllPage(@Param("name") String name, Pageable pageable);
}