package _16_io_text_file.bai_tap.doc_file_csv;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ReadFile {
    public static final String COMMA = ",";

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Mời nhập file csv: ");
        String fileCsv = sc.nextLine();
        // src\\_16_io_text_file\\bai_tap\\doc_file_csv\\nation.csv
        readCsvLine(fileCsv);
    }

    public static void readCsvLine(String path) throws IOException {
        BufferedReader br = null;
        try {
            Reader reader = new FileReader(path);
            br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null) {
                printNation(parseCsvLine(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null)
                br.close();
        }
    }

    public static List<String> parseCsvLine(String csvLine) {
        List<String> result = new ArrayList<>();
        if (csvLine != null) {
            String[] splitData = csvLine.split(COMMA);
            Collections.addAll(result, splitData);
        }
        return result;
    }

    private static void printNation(List<String> nation) {
        System.out.println(
                "[id= "
                        + nation.get(0)
                        + ", code= " + nation.get(1)
                        + " , name=" + nation.get(2)
                        + "]");
    }
}
