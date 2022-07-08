package _16_io_text_file.bai_tap.doc_file_csv;

import _19_io_bonus.Staff;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ReadFileCsv {
    public static final String COMMA = ",";

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Mời nhập file csv: ");
        String fileCsv = sc.nextLine();

        // src\\_16_io_text_file\\bai_tap\\doc_file_csv\\nation.csv
        List<Nation> nationList = readFileCsv(fileCsv);
        for (Nation n : nationList) {
            System.out.println(n);
        }
    }

    public static List<Nation> readFileCsv(String path) throws IOException {
        List<Nation> nationList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] result = line.split(COMMA);
                int id = Integer.parseInt(result[0]);
                String code = result[1];
                String name = result[2];
                nationList.add(new Nation(id, code, name));
            }
        }
        return nationList;
    }

}
