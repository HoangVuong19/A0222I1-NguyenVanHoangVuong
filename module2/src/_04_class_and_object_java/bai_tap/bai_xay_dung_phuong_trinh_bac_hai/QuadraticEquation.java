package _04_class_and_object_java.bai_tap.bai_xay_dung_phuong_trinh_bac_hai;

public class QuadraticEquation {
    double a, b, c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getDiscriminant() {
        double delta;
        delta = Math.pow(b, 2) - 4 * a * c;
        return delta;
    }

    public double getRoot1(double delta) {
        return (-b + Math.sqrt(delta)) / 2 * a;
    }

    public double getRoot2(double delta) {
        return (-b - Math.sqrt(delta)) / 2 * a;
    }
}
