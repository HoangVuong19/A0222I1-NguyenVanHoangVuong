package _04_class_and_object_java.bai_tap.bai_xay_dung_lop_fan;

public class Main {
    public static void main(String[] args) {
        Fan fan = new Fan();
        fan.setSpeed(3);
        fan.setRadius(10);
        fan.setColor("yellow");
        fan.setOn(true);

        Fan fan2 = new Fan();
        fan2.setSpeed(2);
        fan2.setRadius(5);
        fan2.setColor("blue");
        fan2.isOn();

        System.out.println("Thông tin của quạt 1:\n" + fan.toString());
        System.out.println("Thông tin của quạt 2:\n" + fan2.toString());
    }
}
