package _06_ke_thua_java.bai_tap.bai_lop_point2d_va_point3d;

public class Main {
    public static void main(String[] args) {
        Point2D point2D = new Point2D(5, 8);
        System.out.println(point2D);

        Point3D point3D = new Point3D(6, 7, 8);
        float[] res = point3D.getXYZ();
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
        System.out.println(point3D);
    }
}
