package _03_array_and_method_java.bai_tap.bai_dem_so_lan_xuat_hien_ky_tu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] str = "Mou is the special one".split("");

        System.out.println("Chuỗi ký tự là: ");
        for (int i = 0; i < str.length; i++) {
            System.out.print(str[i]);
        }

        System.out.print("\nNhập ký tự: ");
        char chr = scanner.next().charAt(0);

        int count = 0;
        for (int i = 0; i < str.length; i++)
            if (str[i].charAt(0) == chr) {
                count++;
            }
        System.out.println("Số lần xuất hiện là: " + count);
    }
}

