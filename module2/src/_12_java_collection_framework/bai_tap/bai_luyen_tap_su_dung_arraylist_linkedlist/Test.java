package _12_java_collection_framework.bai_tap.bai_luyen_tap_su_dung_arraylist_linkedlist;

import java.util.Scanner;

public class Test {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ProductManager pm = new ProductManager();


    public static void main(String[] args) {
        int choose = 0;
        do {
            System.out.println("MENU------------------------------");
            System.out.println(
                    "1. Thêm sản phẩm\n" +
                            "2. Sửa thông tin sản phẩm theo id\n" +
                            "3. Xoá sản phẩm theo id\n" +
                            "4. Hiển thị danh sách sản phẩm\n" +
                            "5. Tìm kiếm sản phẩm theo tên\n" +
                            "6. Sắp xếp sản phẩm tăng dần/ giảm dần theo giá\n" +
                            "7. Exit"
            );

            try {
                System.out.println("Vui lòng chọn chức năng: ");
                choose = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Vui lòng lựa chọn đúng!!!");
            }

            switch (choose) {
                case 1:
                    add();
                    break;
                case 2:
                    update();
                    break;
                case 3:
                    delete();
                    break;
                case 4:
                    display();
                    break;
                case 5:
                    find();
                    break;
                case 6:
                    sort();
                    break;
                case 7:
                    System.out.println("Cảm ơn quý khách, hẹn gặp lại!!");
                    break;
                default:
                    System.out.println("Vui lòng lựa chọn đúng!!!");
            }
        } while (choose != 7);
    }

    private static void add() {
        System.out.println("Nhập Id của sản phẩm:");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tên sản phẩm:");
        String name = scanner.nextLine();
        System.out.println("Nhập giá sản phẩm:");
        float price = Float.parseFloat(scanner.nextLine());
        Product product = new Product(id, name, price);
        pm.add(product);
        System.out.println("Nhập thành công!!");
    }

    private static void update() {
        System.out.println("Nhập Id sản phẩm cần sửa thông tin:");
        int id = Integer.parseInt(scanner.nextLine());
        Product checkId = new Product(id);
        if (pm.checkIsNotEmpty(checkId)) {
            System.out.println("Nhập tên sản phẩm:");
            String name = scanner.nextLine();
            System.out.println("Nhập giá sản phẩm:");
            float price = Float.parseFloat(scanner.nextLine());
            Product product = new Product(id, name, price);
            pm.update(product);
            System.out.println("Sửa thành công!!");
        } else {
            System.out.println("Sản phẩm không có trong danh sách!!");
        }
    }

    private static void delete() {
        System.out.println("Nhập Id sản phẩm cần xóa:");
        int id = Integer.parseInt(scanner.nextLine());
        Product checkId = new Product(id);
        if (pm.checkIsNotEmpty(checkId)) {
            pm.delete(id);
            System.out.println("Xóa thành công!!");
        } else {
            System.out.println("Sản phẩm không có trong danh sách!!");
        }
    }

    private static void display() {
        System.out.println("Danh sách sản phẩm bao gồm: ");
        pm.display().forEach(System.out::println);
    }

    private static void find() {
        System.out.println("Nhập tên sản phẩm cần tìm kiếm:");
        String name = scanner.nextLine();
        Product checkName = new Product(name);
        if (pm.checkIsNotEmpty(checkName)) {
            pm.find(name).forEach(System.out::println);
        } else {
            System.out.println("Sản phẩm không có trong danh sách!!");
        }
    }

    private static void sort() {
        System.out.println("Bạn muốn sắp xếp như thế nào?\n1. Tăng dần\n2. Giảm dần");
        int choice = Integer.parseInt(scanner.nextLine());
        pm.sort(choice == 1);
    }
}
