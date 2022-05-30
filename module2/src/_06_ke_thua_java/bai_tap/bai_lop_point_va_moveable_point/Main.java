package _06_ke_thua_java.bai_tap.bai_lop_point_va_moveable_point;

public class Main {
    public static void main(String[] args) {
        Point point = new Point(3, 5);
        System.out.println(point);

        MoveablePoint movea = new MoveablePoint(4, 6, 8, 10);
        System.out.println(movea);
        movea.move();
        System.out.println(movea);
    }
}
