package _16_io_text_file.thuc_hanh.tim_gia_tri_lon_nhat_ghi_ra_file;

import java.util.List;
import java.util.Scanner;

public class MaxValueFile {
    public static void main(String[] args) throws Exception {
        System.out.println("Nhập đường dẫn file: ");
        Scanner sc = new Scanner(System.in);
        String path = sc.nextLine();

        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        List<Integer> numbers = readAndWriteFile.readFile(path);
        int maxValue = findMax(numbers);
        readAndWriteFile.writeFile(path, maxValue);
    }

    public static int findMax(List<Integer> numbers) {
        int max = numbers.get(0);
        for (Integer number : numbers) {
            if (max < number) {
                max = number;
            }
        }
        return max;
    }
}
