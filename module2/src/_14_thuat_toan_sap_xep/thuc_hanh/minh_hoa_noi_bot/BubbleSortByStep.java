package _14_thuat_toan_sap_xep.thuc_hanh.minh_hoa_noi_bot;

import java.util.Scanner;

public class BubbleSortByStep {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập kích thước danh sách:");
        int size = scanner.nextInt();
        int[] list = new int[size];
        System.out.println("Nhập " + list.length + " giá trị:");
        for (int i = 0; i < list.length; i++) {
            list[i] = scanner.nextInt();
        }
        System.out.print("Danh sách của bạn: ");
        for (int j : list) {
            System.out.print(j + "\t");
        }

        System.out.println("\nBắt đầu quá trình sắp xếp...");
        bubbleSortByStep(list);
    }

    public static void bubbleSortByStep(int[] list) {
        int length = list.length;
        boolean needNextPass = true;
        for (int k = 1; k < length && needNextPass; k++) {
            needNextPass = false;
            for (int i = 0; i < length - k; i++) {
                if (list[i] > list[i + 1]) {

                    System.out.println("Swap " + list[i] + " with " + list[i + 1]);
                    int temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;

                    needNextPass = true;
                }
            }

            if (!needNextPass){
                break;
            }

            System.out.print("Danh sách sau " + k + " lần sắp xếp: ");
            for (int i : list) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }
}
