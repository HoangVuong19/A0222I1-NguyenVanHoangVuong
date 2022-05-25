package _04_class_and_object_java.bai_tap.bai_xay_dung_lop_fan;

public class Fan {
    private final int slow = 1;
    private final int medium = 2;
    private final int fast = 3;
    private int speed = slow;
    private boolean on = false;
    private double radius = 5;
    private String color = "blue";


    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        if (speed == slow) {
            this.speed = 1;
        } else if (speed == medium) {
            this.speed = 2;
        } else {
            this.speed = 3;
        }
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString() {
        String result;
        if (on) {
            result = String.format("Speed: %d, Color: %s, Radius: %.1f. Fan is On", speed, color, radius);
        } else {
            result = String.format("Color: %s, Radius: %.1f. Fan is Off", color, radius);
        }
        return result;
    }
}
