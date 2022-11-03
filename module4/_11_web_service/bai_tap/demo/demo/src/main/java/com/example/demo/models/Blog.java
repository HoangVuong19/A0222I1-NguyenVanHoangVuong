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
    private Integer id;
    private String name;
    private String content;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}
