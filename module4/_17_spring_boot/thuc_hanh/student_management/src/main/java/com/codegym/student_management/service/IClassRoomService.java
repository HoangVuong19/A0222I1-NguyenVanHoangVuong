package com.codegym.student_management.service;

import com.codegym.student_management.model.ClassRoom;

import java.util.List;

public interface IClassRoomService {
    List<ClassRoom> findAll();
}
