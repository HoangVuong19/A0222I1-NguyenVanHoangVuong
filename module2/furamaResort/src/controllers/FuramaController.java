package controllers;

import java.util.Scanner;

public class FuramaController {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        displayMainMenu();
    }

    public static void displayMainMenu() {
        String choose = "";
        loop:
        while (true) {
            System.out.println("MENU-----------------------------");
            System.out.println(
                    "1. Employee Management\n" +
                            "2. Customer Management\n" +
                            "3. Facility Management\n" +
                            "4. Booking Management\n" +
                            "5. Promotion Management\n" +
                            "6. Exit"
            );
            System.out.println("Choose please: ");
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    employeeManagement();
                    break;
                case "2":
                    customerManagement();
                    break;
                case "3":
                    facilityManagement();
                    break;
                case "4":
                    bookingManagement();
                    break;
                case "5":
                    promotionManagement();
                    break;
                case "6":
                    System.out.println("Thank you, see you soon!!");
                    break loop;
                default:
                    System.out.println("Please choose the correct option!!!");
            }
        }
    }

    public static void employeeManagement() {
        String choose = "";
        loop:
        while (true) {
            System.out.println("Employee Management-------------------------");
            System.out.println(
                    "1. Display list employees\n" +
                            "2. Add new employee\n" +
                            "3. Edit employee\n" +
                            "4. Return main menu"
            );
            System.out.println("Choose please: ");
            choose = scanner.nextLine();
            switch (choose) {
                case "1":

                    break;
                case "2":

                    break;
                case "3":

                    break;
                case "4":
                    break loop;
                default:
                    System.out.println("Please choose the correct option!!!");
            }
        }
    }

    public static void customerManagement() {
        String choose = "";
        loop:
        while (true) {
            System.out.println("Customer Management-------------------------");
            System.out.println(
                    "1. Display list customers\n" +
                            "2. Add new customer\n" +
                            "3. Edit customer\n" +
                            "4. Return main menu"
            );
            System.out.println("Choose please: ");
            choose = scanner.nextLine();
            switch (choose) {
                case "1":

                    break;
                case "2":

                    break;
                case "3":

                    break;
                case "4":
                    break loop;
                default:
                    System.out.println("Please choose the correct option!!!");
            }
        }
    }

    public static void facilityManagement() {
        String choose = "";
        loop:
        while (true) {
            System.out.println("Facility Management-------------------------");
            System.out.println(
                    "1. Display list facility\n" +
                            "2. Add new facility\n" +
                            "3. Display list facility maintenance\n" +
                            "4. Return main menu"
            );
            System.out.println("Choose please: ");
            choose = scanner.nextLine();
            switch (choose) {
                case "1":

                    break;
                case "2":

                    break;
                case "3":

                    break;
                case "4":
                    break loop;
                default:
                    System.out.println("Please choose the correct option!!!");
            }
        }
    }

    public static void bookingManagement() {
        String choose = "";
        loop:
        while (true) {
            System.out.println("Booking Management-------------------------");
            System.out.println(
                    "1. Add new booking\n" +
                            "2. Display list booking\n" +
                            "3. Create new contracts\n" +
                            "4. Display list contracts\n" +
                            "5. Edit contracts\n" +
                            "6. Return main menu"
            );
            System.out.println("Choose please: ");
            choose = scanner.nextLine();
            switch (choose) {
                case "1":

                    break;
                case "2":

                    break;
                case "3":

                    break;
                case "4":

                    break;
                case "5":

                    break;
                case "6":
                    break loop;
                default:
                    System.out.println("Please choose the correct option!!!");
            }
        }
    }

    public static void promotionManagement() {
        String choose = "";
        loop:
        while (true) {
            System.out.println("Promotion Management-------------------------");
            System.out.println(
                    "1. Display list customers use service\n" +
                            "2. Display list customers get voucher\n" +
                            "3. Return main menu"
            );
            System.out.println("Choose please: ");
            choose = scanner.nextLine();
            switch (choose) {
                case "1":

                    break;
                case "2":

                    break;
                case "3":
                    break loop;
                default:
                    System.out.println("Please choose the correct option!!!");
            }
        }
    }
}
