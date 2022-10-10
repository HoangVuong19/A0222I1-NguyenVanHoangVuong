package com.codegym.student_management.service.impl;

import com.codegym.student_management.model.ClassRoom;
import com.codegym.student_management.repository.ClassRoomRepository;
import com.codegym.student_management.service.IClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassRoomService implements IClassRoomService {

    @Autowired
    private ClassRoomRepository classRoomRepository;

    @Override
    public List<ClassRoom> findAll() {
        return classRoomRepository.findAll();
    }
}
