package _07_abstract_class_interface_java.bai_tap.bai_interface_resizeable_cho_lop_hinh_hoc;

import _06_ke_thua_java.thuc_hanh.bai_he_cac_doi_tuong_hinh_hoc.Shape;

public class Rectangle extends Shape implements Resizeable {
    private double width = 1.0;
    private double Height = 1.0;

    public Rectangle() {
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.Height = length;
    }

    public Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.Height = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return Height;
    }

    public void setHeight(double height) {
        this.Height = height;
    }

    public double getArea() {
        return width * Height;
    }

    public double getPerimeter() {
        return 2 * (width + Height);
    }

    @Override
    public String toString() {
        return "A Rectangle with width="
                + getWidth()
                + " and length="
                + getHeight()
                + ", which is a subclass of "
                + super.toString();
    }

    @Override
    public void resize(double percent) {
        width *= percent / 100;
        Height *= percent / 100;
    }
}
