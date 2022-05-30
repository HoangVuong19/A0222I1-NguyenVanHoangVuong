package _07_abstract_class_interface_java.thuc_hanh.bai_interface_comparator_so_sanh_cac_lop_hinh_hoc;

import _07_abstract_class_interface_java.thuc_hanh.bai_interface_comparable_cho_lop_hinh_hoc.Circle;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Circle[] circles = new Circle[3];
        circles[0] = new Circle(3.6);
        circles[1] = new Circle();
        circles[2] = new Circle(3.5, "indigo", false);

        System.out.println("Trước sắp xếp:");
        for (Circle circle : circles) {
            System.out.println(circle);
        }

        Comparator comparatorCircle = new ComparatorCircle();
        Arrays.sort(circles, comparatorCircle);

        System.out.println("Sau sắp xếp:");
        for (Circle circle : circles) {
            System.out.println(circle);
        }
    }
}
