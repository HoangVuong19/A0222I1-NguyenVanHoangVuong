package _04_class_and_object_java.bai_tap.bai_xay_dung_lop_stop_watch;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        double[] arr = new double[10];
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            arr[i] = Math.floor(Math.random() * 10);
        }

        System.out.println("Mảng trước khi sắp xếp");
        System.out.println(Arrays.toString(arr));

        StopWatch stopWatch = new StopWatch();
        selectionSort(arr);
        stopWatch.stop();

        System.out.println("Mảng sau khi sắp xếp");
        System.out.println(Arrays.toString(arr));
        System.out.printf("Elapsed Time: %d ms.", stopWatch.getElapsedTime());
    }

    private static void selectionSort(double[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            int min = i;
            for (int j = i; j < length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }

            if (min != i) {
                double tmp = arr[min];
                arr[min] = arr[i];
                arr[i] = tmp;
            }
        }
    }
}
