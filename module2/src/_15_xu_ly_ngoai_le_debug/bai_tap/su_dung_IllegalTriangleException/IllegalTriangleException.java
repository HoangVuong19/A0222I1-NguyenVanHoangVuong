package _15_xu_ly_ngoai_le_debug.bai_tap.su_dung_IllegalTriangleException;

public class IllegalTriangleException extends Exception {
    private final String error;

    public IllegalTriangleException(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "IllegalTriangleException{" +
                "error='" + error + '\'' +
                '}';
    }
}
