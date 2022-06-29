package _16_io_text_file.bai_tap.copy_file_text;

import java.io.*;
import java.util.Scanner;

public class CopyFileText {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Mời nhập file copy: ");
        String fileCopy = sc.nextLine();
        System.out.println("Mời nhập file lưu: ");
        String filePaste = sc.nextLine();
        readAndWriteFile(fileCopy, filePaste);
        /*
         src\\_16_io_text_file\\bai_tap\\copy_file_text\\inputtext.txt
         src\\_16_io_text_file\\bai_tap\\copy_file_text\\outputtext.txt
        */
    }

    public static void readAndWriteFile(String inputPath, String outputPath) throws IOException {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            Reader reader = new FileReader(inputPath);
            Writer writer = new FileWriter(outputPath);
            br = new BufferedReader(reader);
            bw = new BufferedWriter(writer);

            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line + "\n");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy file!!!");
        } finally {
            if (br != null) br.close();
            if (bw != null) bw.close();
        }
    }
}
