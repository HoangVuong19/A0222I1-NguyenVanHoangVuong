package _01_introduction_java.bai_tap.bai_chuyen_doi_tien_te;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rate = 23000;
        System.out.println("Mời nhập giá trị USD: ");
        float input = scanner.nextFloat();
        System.out.println("Bạn có " + input * rate + " VNĐ");
    }
}
