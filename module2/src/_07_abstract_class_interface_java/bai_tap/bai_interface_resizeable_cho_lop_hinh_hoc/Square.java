package _07_abstract_class_interface_java.bai_tap.bai_interface_resizeable_cho_lop_hinh_hoc;

import _06_ke_thua_java.thuc_hanh.bai_he_cac_doi_tuong_hinh_hoc.Shape;

public class Square extends Shape implements Resizeable {
    private double side = 1;

    public Square(double side) {
        this.side = side;
    }

    public Square(double side, String color, boolean filled) {
        super(color, filled);
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getArea() {
        return side * side;
    }

    public double getPerimeter() {
        return 4 * side;
    }

    @Override
    public String toString() {
        return "A Square with side= "
                + getSide()
                + ", which is a subclass of "
                + super.toString();
    }

    @Override
    public void resize(double percent) {
        side *= percent / 100;
    }
}
