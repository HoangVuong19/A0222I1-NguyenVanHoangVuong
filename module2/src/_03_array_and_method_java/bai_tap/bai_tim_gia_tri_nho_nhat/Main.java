package _03_array_and_method_java.bai_tap.bai_tim_gia_tri_nho_nhat;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[10];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(100);
        }
        System.out.print("Mảng là: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }

        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i])
                min = arr[i];
        }
        System.out.println("\nGiá trị nhỏ nhất là: " + min);
    }
}
