package services.impl;

import models.Employee;
import services.EmployeeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService {
    private static final List<Employee> employeeList = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);

    @Override
    public void display() {
        for (Employee e : employeeList) {
            System.out.println(e.toString());
        }
    }

    @Override
    public void add() {
        System.out.println("Nhập id nhân viên: ");
        String id = sc.nextLine();
        System.out.println("Nhập tên nhân viên: ");
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
        System.out.println("Nhập trình độ: ");
        String qualification = sc.nextLine();
        System.out.println("Nhập vị trí: ");
        String position = sc.nextLine();
        System.out.println("Nhập lương: ");
        double wage = Double.parseDouble(sc.nextLine());

        Employee employee = new Employee(id, name, dateOfBirth, sex, cmnd, phone, email, qualification, position, wage);
        employeeList.add(employee);

        System.out.println("Thêm thành công!!");
    }

    @Override
    public void edit() {
        System.out.println("Nhập id nhân viên muốn sửa: ");
        String id = sc.nextLine();
        int checkId = 0;

        for (Employee employee : employeeList) {
            if (employee.getId().equals(id)) {
                System.out.println("Nhập tên nhân viên: ");
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
                System.out.println("Nhập trình độ: ");
                String qualification = sc.nextLine();
                System.out.println("Nhập vị trí: ");
                String position = sc.nextLine();
                System.out.println("Nhập lương: ");
                double wage = Double.parseDouble(sc.nextLine());

                employee.setName(name);
                employee.setDateOfBirth(dateOfBirth);
                employee.setSex(sex);
                employee.setCmnd(cmnd);
                employee.setPhone(phone);
                employee.setEmail(email);
                employee.setQualification(qualification);
                employee.setPosition(position);
                employee.setWage(wage);
                System.out.println("Cập nhập thành công!!");

                checkId++;
            }
        }
        if (checkId == 0){
            System.out.println("Không tìm thấy id!!");
        }
    }
}
