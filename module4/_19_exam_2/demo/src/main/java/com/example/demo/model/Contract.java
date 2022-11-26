package com.example.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "contract")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank(message = "code is not null")
    @Pattern(regexp = "^HV\\d{3}$", message = "code invalidate")
    private String code;

    @NotBlank(message = "name is not null")
    private String name;

    @NotBlank(message = "phone is not null")
    @Pattern(regexp = "^09[4,5]\\d{7}$",message = "phone invalidate")
    private String phone;

    @Pattern(regexp = "^\\w+\\w*@\\w+\\.\\w+$", message = "email invalidate")
    @NotBlank(message = "email is not null")
    private String email;

    @NotNull(message = "date is not null")
    private Date startDate;

    @NotNull(message = "date is not null")
    private Date endDate;

    @NotNull(message = "shelf is not null")
    private Integer shelf;

    @NotBlank(message = "category is not null")
    private String category;
}