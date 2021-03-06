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
            System.out.print("Nh???p t??n ??i???n tho???i: ");
            name = sc.nextLine();
        } while (!Valid.checkName(name));

        String price = "";
        do {
            System.out.print("Nh???p gi?? ??i???n tho???i: ");
            price = sc.nextLine();
        } while (!Valid.checkDouble(price));

        System.out.print("Nh???p h??ng s???n xu???t: ");
        String manufacturer = Valid.inputWithEmpty("h??ng s???n xu???t");

        Phone phone;
        if (choose == 1) {
            String guarantee = "";
            do {
                System.out.print("Nh???p th???i gian b???o h??nh: ");
                guarantee = sc.nextLine();
            } while (!Valid.checkInt(guarantee));

            System.out.print("Nh???p m?? s??? b???o h??nh: ");
            String code = Valid.inputWithEmpty("m?? s??? b???o h??nh");
            phone = new AuthPhone(0, name, Double.parseDouble(price), manufacturer, Integer.parseInt(guarantee), code);
        } else {
            System.out.print("Nh???p qu???c gia: ");
            String nation = Valid.inputWithEmpty("qu???c gia");
            System.out.print("Nh???p tr???ng th??i ??i???n tho???i: ");
            String status = Valid.inputWithEmpty("tr???ng th??i");
            phone = new HandPhone(0, name, Double.parseDouble(price), manufacturer, nation, status);
        }
        phoneService.addPhone(phone);
        System.out.println("Nh???p th??nh c??ng!!");
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
                System.out.print("Nh???p id ??i???n tho???i mu???n x??a: ");
                int id = Integer.parseInt(sc.nextLine());

                phoneService.delete(id);
                System.out.println("X??a th??nh c??ng");
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
        System.out.print("Nh???p t??n ??i???n tho???i mu???n t??m: ");
        String name = sc.nextLine();
        List<Phone> phones = phoneService.search(name);

        if (phones.size() > 0) {
            for (Phone p : phones) {
                System.out.println(p);
            }
        } else {
            System.out.println("Kh??ng t??m th???y ??i???n tho???i!!");
        }
    }
}
