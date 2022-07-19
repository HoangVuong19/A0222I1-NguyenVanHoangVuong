package utils;

import models.Human;
import models.Staff;
import models.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WriteOrReadFile {
    public static final String COMMA = ",";

    public void write(List<Human> humans, String path, boolean isAppend) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, isAppend))) {
            for (Human p : humans) {
                bw.write(p.toData(COMMA));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Human> read(String path) {
        List<Human> humanList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                String[] result = line.split(COMMA);
                String id = result[1];
                String name = result[2];
                String dateOfBirth = result[3];
                String address = result[4];
                String phone = result[5];

                if (result[0].equals("Staff:")) {
                    Double wage = Double.parseDouble(result[6]);
                    String position = result[7];
                    String location = result[8];
                    humanList.add(new Staff(id, name, dateOfBirth, address, phone, wage, position, location));
                } else {
                    Double point = Double.parseDouble(result[6]);
                    String className = result[7];
                    String date = result[8];
                    humanList.add(new Student(id, name, dateOfBirth, address, phone, point, className, date));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return humanList;
    }
}
