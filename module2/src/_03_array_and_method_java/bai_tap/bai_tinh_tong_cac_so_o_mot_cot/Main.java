package _03_array_and_method_java.bai_tap.bai_tinh_tong_cac_so_o_mot_cot;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float[][] matrix = new float[3][3];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = new Random().nextFloat() * 100;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("Vị trí cột muốn tính tổng: ");
        int site = scanner.nextInt();

        float total = 0;
        for (int i = 0; i < matrix.length; i++) {
            total += matrix[i][site - 1];
        }
        System.out.println("Tổng là: " + total);
    }
}
