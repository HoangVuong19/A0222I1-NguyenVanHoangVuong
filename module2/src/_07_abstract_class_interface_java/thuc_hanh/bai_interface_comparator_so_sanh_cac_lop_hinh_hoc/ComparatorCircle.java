package _07_abstract_class_interface_java.thuc_hanh.bai_interface_comparator_so_sanh_cac_lop_hinh_hoc;

import _07_abstract_class_interface_java.thuc_hanh.bai_interface_comparable_cho_lop_hinh_hoc.Circle;

import java.util.Comparator;

public class ComparatorCircle implements Comparator<Circle> {
    @Override
    public int compare(Circle c1, Circle c2) {
        if (c1.getRadius() > c2.getRadius()) return 1;
        else if (c1.getRadius() < c2.getRadius()) return -1;
        else return 0;
    }
}
