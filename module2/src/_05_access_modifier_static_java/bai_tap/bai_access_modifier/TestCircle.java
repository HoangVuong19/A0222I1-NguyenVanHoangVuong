package _05_access_modifier_static_java.bai_tap.bai_access_modifier;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println("Bán kính hình tròn là: " + circle.getRadius());
        System.out.println("Diện tích hình tròn là: " + circle.getArea());
    }
}
