package _17_io_binary_file_serialization.thuc_hanh.doc_va_ghi_ra_file_nhi_phan;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Vũ Kiều Anh", "Hà Nội"));
        students.add(new Student(2, "Nguyễn Minh Quân", "Hà Nội"));
        students.add(new Student(3, "Đặng Huy Hoà", "Đà Nẵng"));
        students.add(new Student(4, "Nguyễn Khánh Tùng", "Hà Nội"));
        students.add(new Student(5, "Nguyễn Khắc Nhật", "Hà Nội"));
        writeToFile("src\\_17_io_binary_file_serialization\\thuc_hanh\\doc_va_ghi_ra_file_nhi_phan\\student.txt", students);

        readDataFromFile("src\\_17_io_binary_file_serialization\\thuc_hanh\\doc_va_ghi_ra_file_nhi_phan\\student.txt");
    }

    public static void writeToFile(String path, List<Student> students) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
        oos.writeObject(students);
        oos.close();
        System.out.println("Write is complete!!!");
    }

    public static void readDataFromFile(String path) throws Exception {
        List<Student> students;

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
        students = (List<Student>) ois.readObject();
        ois.close();

        for (Student s : students) {
            System.out.println(s);
        }
    }
}
