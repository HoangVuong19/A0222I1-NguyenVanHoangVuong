package com.codegym.student_management.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String studentName;
    private String age;

    @ManyToOne
    @JoinColumn(name = "class_room_id")
    private ClassRoom classRoom;
}