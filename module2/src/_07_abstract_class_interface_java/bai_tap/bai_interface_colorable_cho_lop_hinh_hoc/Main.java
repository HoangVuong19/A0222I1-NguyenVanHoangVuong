package _07_abstract_class_interface_java.bai_tap.bai_interface_colorable_cho_lop_hinh_hoc;

public class Main {
    public static void main(String[] args) {
        Shape[] Colorable = new Shape[2];
        Colorable[0] = new Circle(0.5, "black", true);
        Colorable[1] = new Square(2.5, "white", false);

        for (Shape c : Colorable) {
            if (c instanceof Colorable) {
                ((Colorable) c).howToColor();
                System.out.println(c);
            } else {
                System.out.println(c);
            }
        }
    }
}
