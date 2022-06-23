package _14_thuat_toan_sap_xep.thuc_hanh.cai_thuat_toan_noi_bot;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
        bubbleSort(list);
        display(list);
    }

    public static void bubbleSort(int[] list) {
        int length = list.length;
        boolean needNextPass = true;

        for (int k = 1; k < length && needNextPass; k++) {

            needNextPass = false;
            for (int i = 0; i < length - k; i++) {
                if (list[i] > list[i + 1]) {
                    int temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;

                    needNextPass = true;
                }
            }
        }
    }

    private static void display(int[] list) {
        for (int i : list) {
            System.out.printf("%d ", i);
        }
    }
}
