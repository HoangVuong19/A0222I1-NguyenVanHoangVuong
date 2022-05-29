package _06_ke_thua_java.bai_tap.bai_lop_circle_va_cylinder;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(0.1, "red");
        System.out.println(circle.getArea());
        System.out.println(circle);


        Cylinder cylinder = new Cylinder(0.2,"blue",2.3);
        System.out.println(cylinder.getVolume());
        System.out.println(cylinder);
    }
}
