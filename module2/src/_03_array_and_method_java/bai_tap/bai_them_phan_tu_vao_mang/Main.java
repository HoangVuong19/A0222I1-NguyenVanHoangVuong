package _03_array_and_method_java.bai_tap.bai_them_phan_tu_vao_mang;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = {1, 2, 3, 4, 5};
        System.out.print("Mảng là: ");
        display(arr);

        System.out.print("\nNhập phần tử cần thêm: ");
        int input = scanner.nextInt();

        System.out.print("Nhập vị trí thêm: ");
        int site = scanner.nextInt();

        int[] newArr = add(input, site, arr);

        System.out.print("Mảng mới sau khi thêm là: ");
        display(newArr);
    }

    public static void display(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "  ");
        }
    }

    public static int[] add(int input, int site, int[] array) {
        int[] newArr = new int[array.length + 1];

        for (int i = 0; i < array.length; i++) {
            newArr[i] = array[i];
        }

        for (int i = array.length; i > (site - 1); i--) {
            if (i != (site - 1)) {
                newArr[i] = array[i - 1];
            }
        }
        newArr[(site - 1)] = input;
        return newArr;
    }

}
