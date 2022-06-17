package _11_dsa_stack_queue.bai_tap.bai_chuyen_doi_thap_phan_sang_nhi_phan;

import java.util.Scanner;
import java.util.Stack;

public class BinaryTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("mời nhập số thập phân: ");
        int number = scanner.nextInt();
        Stack<Integer> stack = new Stack<>();

        while (number != 0) {
            stack.push(number % 2);
            number = number / 2;
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}
