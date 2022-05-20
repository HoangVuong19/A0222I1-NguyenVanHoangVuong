package _02_loop_java.bai_tap.bai_hien_thi_cac_loai_hinh;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        stop:
        while (true) {
            System.out.println("Menu");
            System.out.println("1. Print the rectangle");
            System.out.println("2. Print the square triangle");
            System.out.println("3. Print isosceles triangle");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            if (choice == 1) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 7; j++) {
                        System.out.print("*");
                    }
                    System.out.println();
                }
                System.out.println();
            } else if (choice == 2) {
                for (int i = 1; i <= 5; i++) {
                    for (int j = 1; j <= i; j++) {

                        System.out.print("*");
                    }
                    System.out.println();
                }
                System.out.println();

                for (int i = 5; i >= 1; i--) {
                    for (int j = 1; j <= i; j++) {

                        System.out.print("*");
                    }
                    System.out.println();
                }
                System.out.println();

                for (int i = 1; i <= 5; i++) {
                    for (int j = 1; j <= 5; j++) {
                        if (j <= 5 - i) {
                            System.out.print(" ");
                        } else {
                            System.out.print("*");
                        }
                    }
                    System.out.println();
                }
                System.out.println();

                for (int i = 5; i >= 1; i--) {
                    for (int j = 1; j <= 5; j++) {
                        if (j <= 5 - i) {
                            System.out.print(" ");
                        } else {
                            System.out.print("*");
                        }
                    }
                    System.out.println();
                }
                System.out.println();
            } else if (choice == 3) {
                for (int x = 1; x <= 5; x++) {
                    for (int y = 1; y < 2 * 5; y++) {
                        if (Math.abs(5 - y) <= x - 1) {
                            System.out.print("*");
                        } else {
                            System.out.print(" ");
                        }
                    }
                    System.out.println();
                }
                System.out.println();
            }
            else if(choice == 4) {
                break stop;
            }
            else {
                System.out.println("No choice!");
            }
        }
    }
}
