package com.example.demo.service;

import com.example.demo.dto.StudentDTO;
import com.example.demo.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IStudentService {
    List<Student> findAllStudent();

    Page<Student> paging(String name, Pageable pageable);

    void save(StudentDTO student);

    Optional<Student> findById(Long id);

    void remove(Long id);
}
