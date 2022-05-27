package _05_access_modifier_static_java.bai_tap.bai_xay_dung_lop_chi_ghi_trong_java;

public class Student {
    private String name = "John";
    private String classes = "CO2";

    public Student() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String toString() {
        return "Student: name " + name + ", classes " + classes;
    }
}
