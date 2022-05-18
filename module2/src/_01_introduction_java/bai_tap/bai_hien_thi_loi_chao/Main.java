package _01_introduction_java.bai_tap.bai_hien_thi_loi_chao;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập tên của bạn: ");
        String name = scanner.nextLine();

        System.out.println("Xin chào " + name);
    }
}
