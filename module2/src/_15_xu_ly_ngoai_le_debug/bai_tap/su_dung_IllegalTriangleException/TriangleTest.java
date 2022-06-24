package _15_xu_ly_ngoai_le_debug.bai_tap.su_dung_IllegalTriangleException;

import java.util.Scanner;

public class TriangleTest {
    public static void main(String[] args) throws IllegalTriangleException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input side 1: ");
        double side1 = Double.parseDouble(scanner.nextLine());
        System.out.print("Input side 2: ");
        double side2 = Double.parseDouble(scanner.nextLine());
        System.out.print("Input side 3: ");
        double side3 = Double.parseDouble(scanner.nextLine());
        check(side1, side2, side3);
    }

    public static void check(double a, double b, double c) throws IllegalTriangleException {
        if (a < 0 || b < 0 || c < 0) {
            throw new IllegalTriangleException("Cạnh nhỏ hơn 0!!");
        }

        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalTriangleException("Tổng hai cạnh không lớn hơn cạnh còn lại!!");
        }
        double perimeter;
        perimeter = a + b + c;
        System.out.println("Chu vi của tam giác là: " + perimeter);
    }
}




