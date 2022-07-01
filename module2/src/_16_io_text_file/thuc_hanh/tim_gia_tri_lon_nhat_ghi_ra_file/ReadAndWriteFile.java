package _16_io_text_file.thuc_hanh.tim_gia_tri_lon_nhat_ghi_ra_file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {
    public List<Integer> readFile(String filePath) throws Exception {
        List<Integer> numbers = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filePath));

        String line;
        while ((line = br.readLine()) != null) {
            numbers.add(Integer.parseInt(line));
        }
        br.close();
        return numbers;
    }

    public void writeFile(String filePath, int max) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true));
        bw.write("\nGiá trị lớn nhất là: " + max);
        bw.close();
    }
}
