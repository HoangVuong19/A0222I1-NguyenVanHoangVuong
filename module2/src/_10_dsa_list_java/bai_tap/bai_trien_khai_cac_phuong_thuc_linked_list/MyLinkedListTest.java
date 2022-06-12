package _10_dsa_list_java.bai_tap.bai_trien_khai_cac_phuong_thuc_linked_list;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<String> customLinkedList = new MyLinkedList<>();
        customLinkedList.addFirst("2");
        customLinkedList.addFirst("1");
        customLinkedList.addLast("3");
        customLinkedList.add(1, "CodeGym");

        System.out.println(customLinkedList.getFirst());
        System.out.println(customLinkedList.getLast());
        System.out.println(customLinkedList.get(1));
        System.out.println(customLinkedList.contains("2"));
        System.out.println(customLinkedList.indexOf("3"));

    }
}
