package com.codegym.register.model;

import com.codegym.register.utils.validate.EmailValidate;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank(message = "không được để trống")
    private String firstName;

    @NotBlank(message = "không được để trống")
    private String lastName;

    @NotBlank(message = "không được để trống")
    private String phoneNumber;

    @NotNull(message = "không được để trống")
    private Integer age;

    @NotBlank(message = "không được để trống")
    @EmailValidate
    private String email;
}