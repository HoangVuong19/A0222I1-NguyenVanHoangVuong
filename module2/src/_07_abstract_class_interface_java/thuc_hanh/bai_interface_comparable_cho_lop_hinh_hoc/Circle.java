package _07_abstract_class_interface_java.thuc_hanh.bai_interface_comparable_cho_lop_hinh_hoc;

public class Circle {
    private double radius = 1;
    private String color = "green";
    private boolean filled = true;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        this.radius = radius;
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        String isFilled = isFilled() ? "đã tô màu" : "chưa tô màu";
        return "Hình tròn có màu " + color + " và " + isFilled + " có bán kính là " + radius;
    }
}
