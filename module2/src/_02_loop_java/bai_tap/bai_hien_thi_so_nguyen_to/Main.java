package _02_loop_java.bai_tap.bai_hien_thi_so_nguyen_to;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số phần tử cần in ra: ");
        int numbers = scanner.nextInt();
        int n = 2;

        for (int i = 0; i < numbers; ) {
            int count = 0;
            for (int j = 1; j <= n; j++) {
                if (n % j == 0) {
                    count += 1;
                }
            }
            if (count == 2) {
                System.out.print(n + " ");
                i++;
            }
            n++;
        }
    }
}
