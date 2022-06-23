package _14_thuat_toan_sap_xep.bai_tap.cai_thuat_toan_chen;

public class InsertionSort {
    public static void main(String[] args) {
        int[] list = {32, 1, 59, 18, 12};

        insertionSort(list);
        display(list);
    }

    private static void insertionSort(int[] list) {
        int length = list.length;
        for (int i = 0; i < length - 1; i++) {
            int tmp = list[i + 1];
            int position = i;

            while (position >= 0 && list[position] > tmp) {
                list[position + 1] = list[position];
                position--;
            }

            list[position + 1] = tmp;
        }
    }

    private static void display(int[] list) {
        for (int i : list) {
            System.out.printf("%d ", i);
        }
    }
}
