package _06_ke_thua_java.bai_tap.bai_lop_circle_va_cylinder;

public class Cylinder extends Circle {
    private double height;

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume() {
        return getRadius() * getRadius() * getHeight() * Math.PI;
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "height=" + getHeight() +
                ", radius=" + getRadius() +
                ", color='" + getColor() + '\'' +
                '}';
    }
}
