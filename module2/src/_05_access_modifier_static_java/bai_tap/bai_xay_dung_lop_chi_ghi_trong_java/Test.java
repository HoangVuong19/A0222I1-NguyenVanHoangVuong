package _05_access_modifier_static_java.bai_tap.bai_xay_dung_lop_chi_ghi_trong_java;

public class Test {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Vương");
        student.setClasses("A0222");

        System.out.print(student.toString());
    }
}
