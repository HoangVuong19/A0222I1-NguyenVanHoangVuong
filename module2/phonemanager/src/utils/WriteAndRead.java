package utils;

import models.AuthPhone;
import models.HandPhone;
import models.Phone;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WriteAndRead {
    public static final String COMMA = ",";

    public void write(List<Phone> phones, String path, boolean isAppend) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, isAppend))) {
            for (Phone p : phones) {
                bw.write(p.toData(COMMA));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Phone> read(String path) {
        List<Phone> phoneList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                String[] result = line.split(COMMA);
                int id = Integer.parseInt(result[1]);
                String name = result[2];
                double price = Double.parseDouble(result[3]);
                String manufacturer = result[4];

                if (result[0].equals("AuthPhone:")) {
                    int guaranteeByYear = Integer.parseInt(result[5]);
                    String code = result[6];
                    phoneList.add(new AuthPhone(id, name, price, manufacturer, guaranteeByYear, code));
                } else {
                    String nation = result[5];
                    String status = result[6];
                    phoneList.add(new HandPhone(id, name, price, manufacturer, nation, status));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return phoneList;
    }
}

