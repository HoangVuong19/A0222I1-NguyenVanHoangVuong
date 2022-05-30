package _06_ke_thua_java.bai_tap.bai_thiet_ke_va_trien_khai_lop_triangle;

import _06_ke_thua_java.thuc_hanh.bai_he_cac_doi_tuong_hinh_hoc.Shape;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập cạnh a của tam giác: ");
        double a = scanner.nextDouble();
        System.out.println("Nhập cạnh b của tam giác: ");
        double b = scanner.nextDouble();
        System.out.println("Nhập cạnh c của tam giác: ");
        double c = scanner.nextDouble();
        System.out.println("Nhập màu sắc của tam giác: ");
        String color = scanner.next();


        Triangle triangle = new Triangle(a, b, c, color);

        System.out.println(triangle);

    }
}
