package _11_dsa_stack_queue.bai_tap.bai_dao_nguoc_phan_tu_mang_dung_stack;

import java.util.Arrays;
import java.util.Stack;

public class InvertElement {
    public static void main(String[] args) {
        Stack<Integer> intStack = new Stack<>();

        Integer[] element = new Integer[3];
        element[0] = 1;
        element[1] = 2;
        element[2] = 3;

        System.out.println("Mảng trước khi đảo ngược:");
        Arrays.asList(element).forEach(System.out::println);

        for (Integer e : element) {
            intStack.push(e);
        }

        int intSize = intStack.size();
        for (int i = 0; i < intSize; i++) {
            element[i] = intStack.pop();
        }

        System.out.println("Mảng sau khi đảo ngược:");
        Arrays.asList(element).forEach(System.out::println);

        System.out.println("-----------------");

        Stack<String> stringStack = new Stack<>();

        String str = "Hello world";
        System.out.println("Chuỗi trước khi đảo ngược:");
        System.out.println(str);

        String[] string = str.split("");

        for (String s : string) {
            stringStack.push(s);
        }

        int stringSize = stringStack.size();
        for (int i = 0; i < stringSize; i++) {
            string[i] = stringStack.pop();
        }

        System.out.println("Chuỗi sau khi đảo ngược:");
        Arrays.asList(string).forEach(System.out::print);
    }
}
