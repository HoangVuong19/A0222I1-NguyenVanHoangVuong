package _19_io_bonus.doc_ghi_file_text;


import _19_io_bonus.Staff;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TypeObject {
    public static final String DELIMITER = ",";

    public static void main(String[] args) throws IOException {
        // File format CSV or format have ","
        List<Staff> staff = new ArrayList<>();

        staff.add(new Staff(1, "Long", "nam"));
        staff.add(new Staff(2, "Tu", "nu"));
        staff.add(new Staff(3, "Duyet", "nam"));
        staff.add(new Staff(4, "Thanh", "nam"));

        writeFileCsv(staff, "src\\_19_io_bonus\\filetext.txt");
        // readFileCsv("src\\_19_io_bonus\\filetext.txt");

        readFileCsv2("src\\_19_io_bonus\\filetext.txt");
    }

    public static void writeFileCsv(List<Staff> staff, String path) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            for (Staff st : staff) {
                bw.write(st.toData(DELIMITER));
                bw.write("\n");
            }
            System.out.println("write is completed!!!");
        }
    }

    public static void readFileCsv2(String path) throws IOException {
        List<Staff> staff = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                String[] result = line.split(DELIMITER);
                int id = Integer.parseInt(result[0]);
                String name = result[1];
                String sex = result[2];
                staff.add(new Staff(id, name, sex));
            }
        }
        for (Staff st: staff) {
            System.out.println(st);
        }
    }

//    public static void readFileCsv(String path) throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader(path));
//        String line;
//        while ((line = br.readLine()) != null) {
//            DisplayCsvLine(parseCsvLine(line));
//        }
//        br.close();
//    }
//
//    public static List<String> parseCsvLine(String csvLine) {
//        List<String> result = new ArrayList<>();
//        if (csvLine != null) {
//            String[] splitData = csvLine.split(DELIMITER);
//            Collections.addAll(result, splitData);
//        }
//        return result;
//    }
//
//    private static void DisplayCsvLine(List<String> line) {
//        List<Staff> staff = new ArrayList<>();
//        staff.add(new Staff(Integer.parseInt(line.get(0)), line.get(1), line.get(2)));
//        for (Staff st: staff) {
//            System.out.println(st);
//        }
//    }
}
