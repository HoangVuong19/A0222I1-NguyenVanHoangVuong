package _07_abstract_class_interface_java.bai_tap.bai_interface_resizeable_cho_lop_hinh_hoc;

import _06_ke_thua_java.thuc_hanh.bai_he_cac_doi_tuong_hinh_hoc.Shape;

public class Circle extends Shape implements Resizeable {
    private double radius = 1;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }

    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    @Override
    public String toString() {
        return "A Circle with radius= "
                + getRadius()
                + ", which is a subclass of "
                + super.toString();
    }

    @Override
    public void resize(double percent) {
        radius *= percent / 100;
    }

}
