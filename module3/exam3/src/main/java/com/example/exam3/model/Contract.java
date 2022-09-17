package com.example.exam3.model;

import java.sql.Date;

public class Contract {
    private int id;
    private String plantId;
    private int area;
    private String status;
    private int floor;
    private String plantType;
    private double price;
    private Date startDate;
    private Date endDate;

    public Contract(int id, String plantId, int area, String status, int floor, String plantType, double price, Date startDate, Date endDate) {
        this.id = id;
        this.plantId = plantId;
        this.area = area;
        this.status = status;
        this.floor = floor;
        this.plantType = plantType;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Contract(String plantId, int area, String status, int floor, String plantType, double price, Date startDate, Date endDate) {
        this.plantId = plantId;
        this.area = area;
        this.status = status;
        this.floor = floor;
        this.plantType = plantType;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlantId() {
        return plantId;
    }

    public void setPlantId(String plantId) {
        this.plantId = plantId;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getPlantType() {
        return plantType;
    }

    public void setPlantType(String plantType) {
        this.plantType = plantType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}