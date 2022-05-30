package _06_ke_thua_java.bai_tap.bai_lop_point2d_va_point3d;

public class Point3D extends Point2D {
    private float z = 0.0f;

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public Point3D() {
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setXYZ(float x, float y, float z) {
        super.x = x;
        super.y = y;
        this.z = z;
    }

    public float[] getXYZ() {
        float[] result = {getX(), getY(), getZ()};
        return result;
    }

    @Override
    public String toString() {
        return "Point3D{" +
                "z=" + getZ() +
                ", x=" + getX() +
                ", y=" + getY() +
                '}';
    }
}
