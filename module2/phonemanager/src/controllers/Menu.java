package controllers;

import models.AuthPhone;
import models.HandPhone;
import models.Phone;
import services.*;
import exceptions.NotFoundException;
import validated.Valid;

import java.util.List;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        displayMainMenu();
    }


    private static final Scanner sc = new Scanner(System.in);
    private static final PhoneService phoneService = new PhoneService();

    public static void displayMainMenu() {
        int choose = 0;
        loop:
        while (true) {
            System.out.println("----------MENU----------");
            System.out.println(
                    "1. Add new phone\n" +
                            "2. Display phone\n" +
                            "3. Delete phone\n" +
                            "4. Search phone\n" +
                            "5. Exit"
            );
            System.out.print("Choose please: ");
            try {
                choose = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please choose the correct option!!!");
            }
            switch (choose) {
                case 1:
                    addPhone();
                    break;
                case 2:
                    displayPhone();
                    break;
                case 3:
                    deletePhone();
                    break;
                case 4:
                    searchPhone();
                    break;
                case 5:
                    System.out.println("Thank you, see you soon!!");
                    break loop;
            }
        }
    }

    public static void addPhone() {
        int choose = 0;
        System.out.println("----------ADD NEW PHONE----------");
        System.out.println(
                "1. Choose Auth Phone\n" +
                        "2. Choose Hand Phone"
        );
        System.out.print("Choose please: ");
        try {
            choose = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Please choose the correct option!!!");
        }
        String name = "";
        do {
            System.out.print("Nhập tên điện thoại: ");
            name = sc.nextLine();
        } while (!Valid.checkName(name));

        String price = "";
        do {
            System.out.print("Nhập giá điện thoại: ");
            price = sc.nextLine();
        } while (!Valid.checkDouble(price));

        System.out.print("Nhập hãng sản xuất: ");
        String manufacturer = Valid.inputWithEmpty("hãng sản xuất");

        Phone phone;
        if (choose == 1) {
            String guarantee = "";
            do {
                System.out.print("Nhập thời gian bảo hành: ");
                guarantee = sc.nextLine();
            } while (!Valid.checkInt(guarantee));

            System.out.print("Nhập mã số bảo hành: ");
            String code = Valid.inputWithEmpty("mã số bảo hành");
            phone = new AuthPhone(0, name, Double.parseDouble(price), manufacturer, Integer.parseInt(guarantee), code);
        } else {
            System.out.print("Nhập quốc gia: ");
            String nation = Valid.inputWithEmpty("quốc gia");
            System.out.print("Nhập trạng thái điện thoại: ");
            String status = Valid.inputWithEmpty("trạng thái");
            phone = new HandPhone(0, name, Double.parseDouble(price), manufacturer, nation, status);
        }
        phoneService.addPhone(phone);
        System.out.println("Nhập thành công!!");
    }

    public static void displayPhone() {
        System.out.println("----------DISPLAY PHONE----------");
        List<Phone> phones = phoneService.display();
        for (Phone p : phones) {
            System.out.println(p);
        }
    }

    public static void deletePhone() {
        System.out.println("----------DELETE PHONE----------");
        while (true) {
            try {
                System.out.print("Nhập id điện thoại muốn xóa: ");
                int id = Integer.parseInt(sc.nextLine());

                phoneService.delete(id);
                System.out.println("Xóa thành công");
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please choose the correct option!!!");
            } catch (NotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void searchPhone() {
        System.out.println("----------SEARCH PHONE----------");
        System.out.print("Nhập tên điện thoại muốn tìm: ");
        String name = sc.nextLine();
        List<Phone> phones = phoneService.search(name);

        if (phones.size() > 0) {
            for (Phone p : phones) {
                System.out.println(p);
            }
        } else {
            System.out.println("Không tìm thấy điện thoại!!");
        }
    }
}
