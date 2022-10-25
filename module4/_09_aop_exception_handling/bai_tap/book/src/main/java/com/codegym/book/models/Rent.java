package com.codegym.book.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "rent")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Rent {
    @Id
    private Integer id;

    private String status;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
}
