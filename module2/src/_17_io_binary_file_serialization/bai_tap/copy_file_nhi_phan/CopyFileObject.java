package _17_io_binary_file_serialization.bai_tap.copy_file_nhi_phan;

import _17_io_binary_file_serialization.bai_tap.quan_ly_san_pham_luu_ra_file_nhi_phan.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CopyFileObject {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Mời nhập file copy: ");
        String fileCopy = sc.nextLine();
        System.out.println("Mời nhập file lưu: ");
        String filePaste = sc.nextLine();


        copyFileBinary(fileCopy, filePaste);
        /*
         src\\_17_io_binary_file_serialization\\bai_tap\\quan_ly_san_pham_luu_ra_file_nhi_phan\\product.txt
         src\\_17_io_binary_file_serialization\\bai_tap\\copy_file_nhi_phan\\productcopy.txt
        */
        readFileBinary(filePaste);

    }

    public static void copyFileBinary(String sourcePath, String destPath) throws IOException {
        InputStream inputStream = new FileInputStream(sourcePath);
        OutputStream outputStream = new FileOutputStream(destPath);

        byte[] bytes = new byte[1024];
        int length;
        while ((length = inputStream.read(bytes)) > 0) {
            outputStream.write(bytes, 0, length);
        }
        inputStream.close();
        outputStream.close();
        System.out.println("Copy completed!!!");
    }

    public static void readFileBinary(String path) throws IOException, ClassNotFoundException {
        List<Product> products = new ArrayList<>();

        FileInputStream fi = new FileInputStream(path);
        ObjectInputStream oi = new ObjectInputStream(fi);
        products = (List<Product>) oi.readObject();
        fi.close();
        oi.close();

        for (Product p : products) {
            System.out.println(p);
        }
    }

}
