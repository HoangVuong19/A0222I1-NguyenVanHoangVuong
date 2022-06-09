package _10_dsa_list_java.bai_tap.bai_trien_khai_cac_phuong_thuc_array_list;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> myList = new MyList<Integer>(3);
        myList.add(2,1);
        myList.add(2,4);
        myList.add(2,5);
        myList.add(1,1);
        myList.add(0,1);
        System.out.println(myList.getSize());




    }
}
