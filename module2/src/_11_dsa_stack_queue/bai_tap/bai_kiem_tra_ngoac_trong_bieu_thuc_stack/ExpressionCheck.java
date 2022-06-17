package _11_dsa_stack_queue.bai_tap.bai_kiem_tra_ngoac_trong_bieu_thuc_stack;

import java.util.Scanner;
import java.util.Stack;

public class ExpressionCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập biểu thức: ");
        String[] str = scanner.nextLine().split("");
        System.out.println("Biểu thức với các dấu ngoặc: " + checkBracket(str));
    }

    public static boolean checkBracket(String[] str) {
        Stack<String> stack = new Stack<>();
        for (String s : str) {
            if (s.equals("(")) {
                stack.push(s);
            }
            if (s.equals(")")) {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
