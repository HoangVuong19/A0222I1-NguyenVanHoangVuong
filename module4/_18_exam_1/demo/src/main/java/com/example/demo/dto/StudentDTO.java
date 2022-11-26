package com.example.demo.dto;

import javax.validation.constraints.NotBlank;
import java.sql.Date;

public class StudentDTO {
    private Long id;

    @NotBlank(message = "name is not null")
    private String name;

    @NotBlank(message = "date is not null")
    private Date birthday;

    @NotBlank(message = "date is not null")
    private Date checkIn;

    @NotBlank(message = "date is not null")
    private Date checkOut;

    @NotBlank(message = "class is not null")
    private Long classRoom;

    public StudentDTO() {
    }

    public StudentDTO(Long id, String name, Date birthday, Date checkIn, Date checkOut, Long classRoom) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.classRoom = classRoom;
    }

    public StudentDTO(String name, Date birthday, Date checkIn, Date checkOut, Long classRoom) {
        this.name = name;
        this.birthday = birthday;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.classRoom = classRoom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public Long getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(Long classRoom) {
        this.classRoom = classRoom;
    }
}
