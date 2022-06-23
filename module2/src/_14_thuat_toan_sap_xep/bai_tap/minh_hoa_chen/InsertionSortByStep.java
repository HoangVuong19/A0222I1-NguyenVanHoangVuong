package _14_thuat_toan_sap_xep.bai_tap.minh_hoa_chen;

public class InsertionSortByStep {
    public static void main(String[] args) {
        int[] list = {32, 1, 59, 18, 12};
        insertionSort(list);
    }

    private static void insertionSort(int[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            int pos = i;
            int tmp = list[i + 1];

            while (pos >= 0 && list[pos] > tmp) {
                list[pos + 1] = list[pos];
                pos--;
            }

            list[pos + 1] = tmp;

            System.out.printf("Lần lặp %d: ", i);
            display(list);
            System.out.println();
        }
    }

    private static void display(int[] arr) {
        for (int i : arr) {
            System.out.printf("%d ", i);
        }
    }
}
