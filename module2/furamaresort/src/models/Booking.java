package models;

import java.time.LocalDate;

public class Booking {
    private int id;
    private LocalDate startDate;
    private LocalDate endDate;
    private String customerId;
    private String facilityName;
    private String serviceType;

    public Booking(int id, LocalDate startDate, LocalDate endDate, String customerId, String facilityName, String serviceType) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.customerId = customerId;
        this.facilityName = facilityName;
        this.serviceType = serviceType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }


    @Override
    public String toString() {
        return "Booking{" +
                "id='" + id + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", customerId='" + customerId + '\'' +
                ", facilityName='" + facilityName + '\'' +
                ", serviceType='" + serviceType + '\'' +
                '}';
    }
}
