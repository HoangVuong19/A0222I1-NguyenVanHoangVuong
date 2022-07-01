package _16_io_text_file.thuc_hanh.tinh_tong_cac_so_trong_file_text;

import java.io.*;
import java.nio.file.Files;
import java.util.Scanner;

public class ReadFileExample {
    public static void main(String[] args) throws Exception {
        System.out.println("Nhập đường dẫn file: ");
        Scanner sc = new Scanner(System.in);
        String path = sc.nextLine();
        //path: "src\\_16_io_text_file\\thuc_hanh\\tinh_tong_cac_so_trong_file_text\\numbers.txt"
        readFileText(path);
    }

    public static void readFileText(String filePath) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;
        int sum = 0;
        while ((line = br.readLine()) != null) {
            sum += Integer.parseInt(line);
        }
        br.close();
        System.out.println(sum);
    }
}
