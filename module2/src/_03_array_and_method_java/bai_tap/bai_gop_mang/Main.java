package _03_array_and_method_java.bai_tap.bai_gop_mang;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[2];
        System.out.println("Nhập phần tử mảng 1: ");
        inputArr(arr);
        System.out.print("Mảng 1 là: ");
        displayArr(arr);

        int[] arr2 = new int[3];
        System.out.println("\nNhập phần tử mảng 2 : ");
        inputArr(arr2);
        System.out.print("Mảng 2 là: ");
        displayArr(arr2);

        int[] newArr = merge(arr, arr2);
        System.out.print("Mảng mới sau khi gộp là: ");
        displayArr(newArr);
    }

    public static void inputArr(int[] array) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
    }

    public static void displayArr(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "  ");
        }
    }

    public static int[] merge(int[] array, int[] array2) {
        int[] newArr = new int[array.length + array2.length];
        for (int i = 0; i < array.length; i++) {
            newArr[i] = array[i];
        }
        for (int i = 0; i < array2.length; i++) {
            newArr[array.length + i] = array2[i];
        }
        return newArr;
    }
}
