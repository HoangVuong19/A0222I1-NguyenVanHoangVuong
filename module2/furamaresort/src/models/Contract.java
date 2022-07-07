package models;

public class Contract {
    private String contractId;
    private int bookingId;
    private double downPayment;
    private double totalPayment;
    private String customerId;

    public Contract() {
    }

    public Contract(String contractId, int bookingId, double downPayment, double totalPayment, String customerId) {
        this.contractId = contractId;
        this.bookingId = bookingId;
        this.downPayment = downPayment;
        this.totalPayment = totalPayment;
        this.customerId = customerId;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public double getDownPayment() {
        return downPayment;
    }

    public void setDownPayment(double downPayment) {
        this.downPayment = downPayment;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "contractId='" + contractId + '\'' +
                ", bookingId='" + bookingId + '\'' +
                ", downPayment=" + downPayment +
                ", totalPayment=" + totalPayment +
                ", customerId='" + customerId + '\'' +
                '}';
    }
}
