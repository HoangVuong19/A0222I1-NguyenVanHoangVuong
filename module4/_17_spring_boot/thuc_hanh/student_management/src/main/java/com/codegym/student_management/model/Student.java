package com.codegym.student_management.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;

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
    @Column(columnDefinition = "DATE")
    private Date dateOfBirth;

    @ManyToOne
    @JoinColumn(name = "class_room_id")
    private ClassRoom classRoom;
}