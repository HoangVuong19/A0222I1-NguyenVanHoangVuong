package _03_array_and_method_java.bai_tap.bai_xoa_phan_tu_khoi_mang;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = {1, 2, 3, 4, 5, 0};
        System.out.print("Mảng là: ");
        display(arr);

        System.out.print("\nNhập phần tử cần xóa: ");
        int input = scanner.nextInt();
        checkInput(input, arr);

        System.out.print("Mảng mới sau khi xóa là: ");
        display(arr);
    }

    public static void display(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "  ");
        }
    }

    public static void checkInput(int input, int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == input) {
                input = i;
                break;
            }
        }

        for (int i = input; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
    }
}
