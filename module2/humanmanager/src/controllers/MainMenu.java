package controllers;

import exceptions.NotFoundException;
import models.Human;
import models.Staff;
import models.Student;
import services.HumanService;
import validated.ValidHuman;

import java.util.List;
import java.util.Scanner;

public class MainMenu {

    public static void main(String[] args) {
        displayMenu();
    }

    private static final Scanner sc = new Scanner(System.in);
    private static final HumanService humanService = new HumanService();

    public static void displayMenu() {
        int choose = 0;
        loop:
        while (true) {
            System.out.println("--CHƯƠNG TRÌNH QUẢN LÝ BỆNH ÁN--");
            System.out.println(
                    "Chọn chức năng theo số (để tiếp tục):\n" +
                            "1. Thêm mới nhân sự\n" +
                            "2. Xóa nhân sự\n" +
                            "3. Xem danh sách nhân sự\n" +
                            "4. Thoát"
            );
            System.out.print("Choose please: ");
            try {
                choose = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please choose the correct option!!!");
            }
            switch (choose) {
                case 1:
                    addHuman();
                    break;
                case 2:
                    deleteHuman();
                    break;
                case 3:
                    displayHuman();
                    break;
                case 4:
                    System.out.println("Thank you, see you soon!!");
                    break loop;
            }
        }
    }

    public static void addHuman() {
        int choose;
        while (true) {
            System.out.println("Chọn loại nhân sự cần thêm");
            System.out.println(
                    "1. Thêm mới nhân viên\n" +
                            "2. Thêm mới học viên\n" +
                            "3. Quay lại"
            );
            System.out.print("Choose please: ");
            try {
                choose = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please choose the correct option!!!");
                continue;
            }
            if (choose == 3) {
                break;
            }
            System.out.print("Nhập mã định danh: ");
            String id = "";
            if (choose == 1) {
                do {
                    id = sc.nextLine();
                    while (true) {
                        if (ValidHuman.checkDuplicatesId(id)) {
                            System.out.println("Mã định danh bị trùng!!");
                            System.out.println("Mời nhập lại mã định danh: ");
                            id = sc.nextLine();
                        } else {
                            break;
                        }
                    }
                } while (!ValidHuman.checkIdStaff(id));
            } else if (choose == 2) {
                do {
                    id = sc.nextLine();
                    while (true) {
                        if (ValidHuman.checkDuplicatesId(id)) {
                            System.out.println("Mã định danh bị trùng: ");
                            System.out.println("Mời nhập lại mã định danh: ");
                            id = sc.nextLine();
                        } else {
                            break;
                        }
                    }
                } while (!ValidHuman.checkIdStudent(id));
            } else {
                System.out.println("Please choose the correct option!!!");
                continue;
            }

            System.out.print("Nhập họ và tên: ");
            String name = ValidHuman.inputWithEmpty("họ và tên");

            String dateOfBirth = "";
            do {
                System.out.print("Nhập ngày sinh: ");
                dateOfBirth = sc.nextLine();
            } while (!ValidHuman.checkDate(dateOfBirth));


            System.out.print("Nhập địa chỉ: ");
            String address = ValidHuman.inputWithEmpty("địa chỉ");

            String phone = "";
            do {
                System.out.print("Nhập số điện thoại: ");
                phone = sc.nextLine();
            } while (!ValidHuman.checkPhone(phone));

            Human human;
            if (choose == 1) {
                String wage = "";
                do {
                    System.out.print("Nhập lương: ");
                    wage = sc.nextLine();
                } while (!ValidHuman.checkDouble(wage));

                System.out.print("Nhập phòng ban: ");
                String position = ValidHuman.inputWithEmpty("phòng ban");

                System.out.print("Nhập vị trí: ");
                String location = ValidHuman.inputWithEmpty("vị trí");

                human = new Staff(id, name, dateOfBirth, address, phone, Double.parseDouble(wage), position, location);
                humanService.addHuman(human);
                System.out.println("Nhập thành công!!");
            } else {
                String point = "";
                do {
                    System.out.print("Nhập điểm thi: ");
                    point = sc.nextLine();
                } while (!ValidHuman.checkDouble(point));

                System.out.print("Nhập tên lớp: ");
                String className = ValidHuman.inputWithEmpty("tên lớp");

                String date = "";
                do {
                    System.out.print("Nhập ngày nhập học: ");
                    date = sc.nextLine();
                } while (!ValidHuman.checkDate(date));

                human = new Student(id, name, dateOfBirth, address, phone, Double.parseDouble(point), className, date);
                humanService.addHuman(human);
                System.out.println("Nhập thành công!!");
            }
        }
    }

    public static void displayHuman() {
        System.out.println("----------DISPLAY----------");
        List<Human> humans = humanService.display();
        for (Human h : humans) {
            System.out.println(h);
        }
    }

    public static void deleteHuman() {
        System.out.println("----------DELETE----------");
        System.out.print("Mời nhập mã định danh muốn xóa: ");
        String id = sc.nextLine();

        System.out.println("1. yes");
        System.out.println("2. no");
        int choose = 0;
        try {
            choose = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Please choose the correct option!!!");
        }
        if (choose == 1) {
            try {
                humanService.delete(id);
                System.out.println("Xóa thành công!!");
                displayHuman();
            } catch (NotFoundException e) {
                System.out.println(e.getMessage());
            }

        }
    }
}
