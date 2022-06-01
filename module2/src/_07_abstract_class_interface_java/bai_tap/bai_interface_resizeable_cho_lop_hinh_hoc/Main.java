package _07_abstract_class_interface_java.bai_tap.bai_interface_resizeable_cho_lop_hinh_hoc;

import _06_ke_thua_java.thuc_hanh.bai_he_cac_doi_tuong_hinh_hoc.Shape;

public class Main {
    public static void main(String[] args) {
        Shape[] resizeable = new Shape[3];
        resizeable[0] = new Circle(5, "red", true);
        resizeable[1] = new Rectangle(5, 9, "yellow", false);
        resizeable[2] = new Square(15, "blue", false);

        for (Shape e : resizeable) {
            if (e instanceof Resizeable) {
                ((Resizeable) e).resize(50);
                System.out.println(e);
            }
        }
    }
}
