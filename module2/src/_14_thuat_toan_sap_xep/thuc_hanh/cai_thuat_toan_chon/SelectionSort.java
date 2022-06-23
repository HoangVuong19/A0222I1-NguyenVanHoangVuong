package _14_thuat_toan_sap_xep.thuc_hanh.cai_thuat_toan_chon;

public class SelectionSort {
    public static void main(String[] args) {
        int[] list = {1, 9, 4, 6, 5, -4};
        selectionSort(list);
        display(list);
    }

    public static void selectionSort(int[] list) {
        int length = list.length;
        for (int i = 0; i < length - 1; i++) {
            int min_position = i;

            for (int j = i + 1; j < length; j++) {
                if (list[min_position] > list[j]) {
                    min_position = j;
                }
            }

            if (min_position != i) {
                int tmp = list[min_position];
                list[min_position] = list[i];
                list[i] = tmp;
            }
        }
    }

    private static void display(int[] list) {
        for (int i : list) {
            System.out.printf("%d ", i);
        }
    }
}
