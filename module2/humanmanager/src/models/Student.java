package models;

public class Student extends Human {
    private Double point;
    private String className;
    private String dateAdmission;

    public Student(String id, String name, String dateOfBirth, String address, String phone, Double point, String className, String dateAdmission) {
        super(id, name, dateOfBirth, address, phone);
        this.point = point;
        this.className = className;
        this.dateAdmission = dateAdmission;
    }

    public Double getPoint() {
        return point;
    }

    public void setPoint(Double point) {
        this.point = point;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getDateAdmission() {
        return dateAdmission;
    }

    public void setDateAdmission(String dateAdmission) {
        this.dateAdmission = dateAdmission;
    }

    @Override
    public String toString() {
        return "Student{" + super.toString() +
                ", point=" + point +
                ", className='" + className + '\'' +
                ", date=" + dateAdmission +
                '}';
    }

    public String toData(String delimiter) {
        return "Student:" + delimiter + super.getId() + delimiter + super.getName() + delimiter + super.getDateOfBirth() + delimiter + super.getAddress()
                + delimiter + super.getPhone() + delimiter + point + delimiter + className + delimiter + dateAdmission;
    }

    @Override
    public int compareTo(Human o) {
        return super.getName().compareTo(o.getName());
    }
}
