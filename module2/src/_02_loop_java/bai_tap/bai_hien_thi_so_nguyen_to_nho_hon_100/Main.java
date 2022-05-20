package _02_loop_java.bai_tap.bai_hien_thi_so_nguyen_to_nho_hon_100;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int i = 1;
        do {
            i++;

            boolean isPrime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                System.out.print(i + " ");
            }
        } while (i < 100);
    }
}
