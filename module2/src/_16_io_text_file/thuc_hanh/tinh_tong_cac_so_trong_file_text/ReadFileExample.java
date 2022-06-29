package _16_io_text_file.thuc_hanh.tinh_tong_cac_so_trong_file_text;

import java.io.*;
import java.nio.file.Files;
import java.util.Scanner;

public class ReadFileExample {
    public static void main(String[] args) {
        System.out.println("Nhập đường dẫn file: ");
        Scanner sc = new Scanner(System.in);
        String path = sc.nextLine();
        //path: "src\\_16_io_text_file\\thuc_hanh\\tinh_tong_cac_so_trong_file_text\\numbers.txt"
        readFileText(path);
    }

    public static void readFileText(String filePath) {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            //BufferedReader br = new BufferedReader(new FileReader(file));
            BufferedReader br = Files.newBufferedReader(file.toPath());
            String line;
            int sum = 0;
            while ((line = br.readLine()) != null) {
                sum += Integer.parseInt(line);
            }
            br.close();
            System.out.println(sum);
        } catch (Exception ex) {
            System.err.println("Fie not exists or content error!");
        }
    }
}
