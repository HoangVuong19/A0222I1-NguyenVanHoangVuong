package _11_dsa_stack_queue.bai_tap.bai_kiem_tra_chuoi_palindrome_su_dung_queue;

import java.util.*;

public class PalindromeTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập chuỗi cần kiểm tra: ");
        String[] str = scanner.nextLine().split("");

        Stack<String> stack = new Stack<>();
        Queue<String> queue = new LinkedList<>();

        for (String s : str) {
            stack.push(s);
            queue.add(s);
        }

        boolean check = true;
        while (!stack.isEmpty()) {
            if (!stack.pop().equals(queue.remove())) {
                check = false;
                break;
            }
        }

        System.out.println(check);
    }
}
