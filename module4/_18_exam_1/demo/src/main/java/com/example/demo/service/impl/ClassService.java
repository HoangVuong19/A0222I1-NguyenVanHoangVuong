package com.example.demo.service.impl;

import com.example.demo.model.ClassRoom;
import com.example.demo.repository.ClassRepository;
import com.example.demo.service.IClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService implements IClassService {

    @Autowired
    private ClassRepository classRepository;

    @Override
    public List<ClassRoom> findAll() {
        return classRepository.findAll();
    }

}
