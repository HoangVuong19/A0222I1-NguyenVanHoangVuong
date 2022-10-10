package com.codegym.student_management.service;

import com.codegym.student_management.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();

    void save(Student student);

    Student findById(Long id);

    void deleteById(Long id);
}
