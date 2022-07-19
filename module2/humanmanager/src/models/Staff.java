package models;

public class Staff extends Human {
    private Double wage;
    private String department;
    private String position;

    public Staff(String id, String name, String dateOfBirth, String address, String phone, Double wage, String department, String position) {
        super(id, name, dateOfBirth, address, phone);
        this.wage = wage;
        this.department = department;
        this.position = position;
    }

    public Double getWage() {
        return wage;
    }

    public void setWage(Double wage) {
        this.wage = wage;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Staff{" + super.toString() +
                ", wage=" + wage +
                ", position='" + department + '\'' +
                ", location='" + position + '\'' +
                '}';
    }

    public String toData(String delimiter) {
        return "Staff:" + delimiter + super.getId() + delimiter + super.getName() + delimiter + super.getDateOfBirth() + delimiter + super.getAddress()
                + delimiter + super.getPhone() + delimiter + wage + delimiter + department + delimiter + position;
    }

    @Override
    public int compareTo(Human o) {
        return super.getName().compareTo(o.getName());
    }
}
