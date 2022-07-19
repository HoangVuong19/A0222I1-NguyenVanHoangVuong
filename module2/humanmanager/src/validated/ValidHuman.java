package validated;

import models.Human;
import services.HumanService;
import utils.WriteOrReadFile;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class ValidHuman {
    public static boolean checkDouble(String value) {
        try {
            Double.parseDouble(value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean checkDate(String date) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate.parse(date, formatter);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean checkIdStaff(String name) {
        return name.matches("(NV-)\\d{3}");
    }

    public static boolean checkIdStudent(String name) {
        return name.matches("(HV-)\\d{3}");
    }

    public static boolean checkPhone(String phone) {
        return phone.matches("(0)\\d{9}");
    }

    public static boolean checkDuplicatesId(String id) {
        WriteOrReadFile writeOrReadFile = new WriteOrReadFile();
        List<Human> result;
        result = writeOrReadFile.read(HumanService.path);

        for (Human human : result) {
            if (human.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public static String inputWithEmpty(String field) {
        Scanner sc = new Scanner(System.in);
        String value = "nothing";
        do {
            if (value.isEmpty()){
                System.out.print("Nhập lại " + field + ": ");
            }
            value = sc.nextLine();
        } while (value.trim().isEmpty());

        return value;
    }
}
