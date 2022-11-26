package com.example.demo.service.impl;

import com.example.demo.dto.StudentDTO;
import com.example.demo.model.ClassRoom;
import com.example.demo.model.Student;
import com.example.demo.repository.ClassRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IStudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ClassRepository classRepository;

    @Override
    public List<Student> findAllStudent() {
        return studentRepository.findAllStudent();
    }

    @Override
    public Page<Student> paging(String name, Pageable pageable) {
        return studentRepository.findAllPage(name, pageable);
    }

    @Override
    public void save(StudentDTO student) {
        Student student1 = new Student();
        if (student.getId() != null){
            student1 = findById(student.getId()).get();
        }
        student1.setName(student.getName());
        student1.setBirthday(student.getBirthday());
        student1.setCheckIn(student.getCheckIn());
        student1.setCheckOut(student.getCheckOut());
        ClassRoom classRoom = classRepository.findById(student.getClassRoom()).orElse(null);
        student1.setClassRoom(classRoom);
        studentRepository.save(student1);
    }

    @Override
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        studentRepository.deleteById(id);
    }
}
