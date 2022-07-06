package services.impl;

import models.Customer;
import services.CustomerService;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
    private static final List<Customer> customerList = new LinkedList<>();
    private static final Scanner sc = new Scanner(System.in);


    @Override
    public void display() {
        for (Customer c : customerList) {
            System.out.println(c.toString());
        }
    }

    @Override
    public void add() {
        System.out.println("Nhập id khách hàng: ");
        String id = sc.nextLine();
        System.out.println("Nhập tên khách hàng: ");
        String name = sc.nextLine();
        System.out.println("Nhập ngày sinh: ");
        String dateOfBirth = sc.nextLine();
        System.out.println("Nhập giới tính: ");
        String sex = sc.nextLine();
        System.out.println("Nhập cmnd: ");
        int cmnd = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập số điện thoại: ");
        String phone = sc.nextLine();
        System.out.println("Nhập email: ");
        String email = sc.nextLine();
        System.out.println("Nhập loại khách hàng: ");
        String typeCustomer = sc.nextLine();
        System.out.println("Nhập địa chỉ: ");
        String address = sc.nextLine();

        Customer customer = new Customer(id, name, dateOfBirth, sex, cmnd, phone, email, typeCustomer, address);
        customerList.add(customer);

        System.out.println("Thêm thành công!!");
    }

    @Override
    public void edit() {
        System.out.println("Nhập id khách hàng muốn sửa: ");
        String id = sc.nextLine();
        int checkId = 0;

        for (Customer customer : customerList) {
            if (customer.getId().equals(id)) {
                System.out.println("Nhập tên khách hàng: ");
                String name = sc.nextLine();
                System.out.println("Nhập ngày sinh: ");
                String dateOfBirth = sc.nextLine();
                System.out.println("Nhập giới tính: ");
                String sex = sc.nextLine();
                System.out.println("Nhập cmnd: ");
                int cmnd = Integer.parseInt(sc.nextLine());
                System.out.println("Nhập số điện thoại: ");
                String phone = sc.nextLine();
                System.out.println("Nhập email: ");
                String email = sc.nextLine();
                System.out.println("Nhập loại khách hàng: ");
                String typeCustomer = sc.nextLine();
                System.out.println("Nhập địa chỉ: ");
                String address = sc.nextLine();

                customer.setName(name);
                customer.setDateOfBirth(dateOfBirth);
                customer.setSex(sex);
                customer.setCmnd(cmnd);
                customer.setPhone(phone);
                customer.setEmail(email);
                customer.setTypeCustomer(typeCustomer);
                customer.setAddress(address);
                System.out.println("Cập nhập thành công!!");

                checkId++;
            }
        }
        if (checkId == 0){
            System.out.println("Không tìm thấy id!!");
        }
    }
}
