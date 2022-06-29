package _17_io_binary_file_serialization.bai_tap.quan_ly_san_pham_luu_ra_file_nhi_phan;

import _17_io_binary_file_serialization.thuc_hanh.doc_va_ghi_ra_file_nhi_phan.Student;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Product> product = new ArrayList<>();
        product.add(new Product(1, "Mazda CX-5", "Mazda", 1000000000, "nothing"));
        product.add(new Product(2, "Honda City", "Honda", 600000000, "nothing"));
        product.add(new Product(3, "Vinfast Fadil", "Vinfast", 400000000, "nothing"));
        product.add(new Product(4, "Hyundai Tucson", "Hyundai", 900000000, "nothing"));
        product.add(new Product(5, " Toyota Vios", "Toyota", 600000000, "nothing"));
        saveFile("src\\_17_io_binary_file_serialization\\bai_tap\\quan_ly_san_pham_luu_ra_file_nhi_phan\\product.txt", product);
        System.out.println("completed!!!");
    }

    public static void saveFile(String path, List<Product> product) throws IOException {
        FileOutputStream fo = null;
        ObjectOutputStream oo = null;
        try {
            fo = new FileOutputStream(path);
            oo = new ObjectOutputStream(fo);
            oo.writeObject(product);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fo != null) fo.close();
            if (oo != null) oo.close();
        }


    }
}
