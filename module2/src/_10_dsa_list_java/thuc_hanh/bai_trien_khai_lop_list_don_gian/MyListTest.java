package _10_dsa_list_java.thuc_hanh.bai_trien_khai_lop_list_don_gian;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> listInteger = new MyList<Integer>();
        listInteger.add(1);
        listInteger.add(2);
        listInteger.add(3);
        listInteger.add(3);
        listInteger.add(4);

        System.out.println("element 4: " + listInteger.get(3));
        System.out.println("element 1: " + listInteger.get(0));
        System.out.println("element 2: " + listInteger.get(1));

        listInteger.add(6);
        System.out.println("element 6: " + listInteger.get(5));
    }
}
