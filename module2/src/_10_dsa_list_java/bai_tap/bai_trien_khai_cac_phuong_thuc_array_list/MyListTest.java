package _10_dsa_list_java.bai_tap.bai_trien_khai_cac_phuong_thuc_array_list;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> myList = new MyList<Integer>();
        myList.add(1);
        myList.add(2);
        myList.add(4);

        System.out.println(myList.size());
        System.out.println(myList.indexOf(2));
    }
}
