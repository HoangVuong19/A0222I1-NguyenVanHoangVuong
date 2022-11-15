package com.example.demo.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "blog")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String name;

    String content;

    String title;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false, referencedColumnName = "id")
    Category category;


}
