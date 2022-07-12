package models;

public class HandPhone extends Phone {
    private String nation;
    private String status;

    public HandPhone(int id, String name, Double price, String manufacturer, String nation, String status) {
        super(id, name, price, manufacturer);
        this.nation = nation;
        this.status = status;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "HandPhone{" + super.toString() +
                " nation='" + nation + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public String toData(String delimiter) {
        return "HandPhone:" + delimiter + super.toData(delimiter) + delimiter + nation + delimiter + status;
    }
}
