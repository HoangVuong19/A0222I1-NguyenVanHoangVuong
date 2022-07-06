package models;

public class Booking {
    private String id;
    private String startDate;
    private String endDate;
    private String customerId;
    private String facilityName;
    private String serviceType;
    private boolean isContract;

    public Booking() {
    }

    public Booking(String id, String startDate, String endDate, String customerId, String facilityName, String serviceType, boolean isContract) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.customerId = customerId;
        this.facilityName = facilityName;
        this.serviceType = serviceType;
        this.isContract = isContract;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
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

    public boolean isContract() {
        return isContract;
    }

    public void setContract(boolean contract) {
        isContract = contract;
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
                ", isContract=" + isContract +
                '}';
    }
}
