package _04_class_and_object_java.bai_tap.bai_xay_dung_phuong_trinh_bac_hai;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào a:");
        double a = scanner.nextDouble();
        System.out.println("Nhập vào b:");
        double b = scanner.nextDouble();
        System.out.println("Nhập vào c:");
        double c = scanner.nextDouble();

        QuadraticEquation equation = new QuadraticEquation(a, b, c);
        double delta = equation.getDiscriminant();

        if (delta > 0) {
            System.out.printf("Phương trình có hai nghiệm là x1 = %.2f, x2 = %.2f",
                    equation.getRoot1(delta), equation.getRoot2(delta));
        } else if (delta == 0) {
            System.out.printf("Phương trình có nghiệm kép là x= " + equation.getRoot1(delta));
        } else {
            System.out.println("Phương trình vô nghiệm");
        }
    }
}
