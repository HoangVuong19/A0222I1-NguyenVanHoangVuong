package _07_abstract_class_interface_java.bai_tap.bai_interface_colorable_cho_lop_hinh_hoc;

public class Square extends Shape implements Colorable {
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
        return "Square{" +
                "side=" + side +
                " area=" + getArea() +
                '}';
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides are " + getColor());
    }
}
