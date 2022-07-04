package _19_io_bonus.doc_ghi_file_binary;

import _19_io_bonus.Customer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TypeObject {
    public static void main(String[] args) throws Exception {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1, "Nguyen Hoang Long", "Da Nang"));
        customers.add(new Customer(2, "Tran Dao Thanh", "Quang Nam"));
        customers.add(new Customer(3, "Ly Cong Anh", "Gia Lai"));
        customers.add(new Customer(4, "Le Cong Vinh", "Thai Binh"));

        writeFileBinary(customers, "src\\_19_io_bonus\\filebyte.txt");

        readFileBinary("src\\_19_io_bonus/\\filebyte.txt");

        // file object not append!!!
    }

    public static void writeFileBinary(List<Customer> students, String path) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(students);
            System.out.println("Write is completed!!!");
        }
    }

    public static void readFileBinary(String path) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            List<Customer> customers = (List<Customer>) ois.readObject();
            for (Customer c : customers) {
                System.out.println(c);
            }
        }
    }
}

