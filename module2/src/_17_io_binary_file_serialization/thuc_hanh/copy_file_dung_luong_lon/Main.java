package _17_io_binary_file_serialization.thuc_hanh.copy_file_dung_luong_lon;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter source file:");
        String sourcePath = in.nextLine();
        System.out.print("Enter destination file:");
        String destPath = in.nextLine();

        /*
         src\\_16_io_text_file\\bai_tap\\copy_file_text\\inputtext.txt
         src\\_16_io_text_file\\bai_tap\\copy_file_text\\outputtext.txt
        */
        copyFileUsingStream(sourcePath, destPath);
    }

    private static void copyFileUsingStream(String source, String dest) {
        try (InputStream is = new FileInputStream(source); OutputStream os = new FileOutputStream(dest)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print("Copy completed");
    }
}
