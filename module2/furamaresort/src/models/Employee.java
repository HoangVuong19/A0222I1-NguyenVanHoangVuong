package models;

public class Employee extends Person {
    private String qualification;
    private String position;
    private double wage;

    public Employee(String qualification, String position, double wage) {
        this.qualification = qualification;
        this.position = position;
        this.wage = wage;
    }

    public Employee(String id, String name, String dateOfBirth, String sex, int cmnd, String phone, String email, String qualification, String position, double wage) {
        super(id, name, dateOfBirth, sex, cmnd, phone, email);
        this.qualification = qualification;
        this.position = position;
        this.wage = wage;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "qualification='" + qualification + '\'' +
                ", position='" + position + '\'' +
                ", wage=" + wage +
                '}' + super.toString();
    }
}
