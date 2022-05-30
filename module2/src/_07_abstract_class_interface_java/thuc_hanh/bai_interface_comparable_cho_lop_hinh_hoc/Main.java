package _07_abstract_class_interface_java.thuc_hanh.bai_interface_comparable_cho_lop_hinh_hoc;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ComparableCircle[] circles = new ComparableCircle[3];
        circles[0] = new ComparableCircle(3.6);
        circles[1] = new ComparableCircle();
        circles[2] = new ComparableCircle(3.5, "indigo", false);

        System.out.println("Trước sắp xếp:");
        for (ComparableCircle circle : circles) {
            System.out.println(circle);
        }

        Arrays.sort(circles);

        System.out.println("Sau sắp xếp:");
        for (ComparableCircle circle : circles) {
            System.out.println(circle);
        }
    }
}
