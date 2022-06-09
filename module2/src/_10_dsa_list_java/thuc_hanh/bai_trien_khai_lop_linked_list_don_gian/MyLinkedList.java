package _10_dsa_list_java.thuc_hanh.bai_trien_khai_lop_linked_list_don_gian;

public class MyLinkedList {
    private Node head;
    private int numNodes;

    public MyLinkedList(Object element) {
        head = new Node(element);
    }

    private class Node {
        private Node next;
        private Object elements;

        public Node(Object data) {
            this.elements = data;
        }

        public Object getElements() {
            return this.elements;
        }
    }

    public void add(int index, Object element) {
        Node current = head;
        Node temp;

        for (int i = 0; i < index - 1 && current.next != null; i++) {
            current = current.next;
        }
        temp = current.next;
        current.next = new Node(element);
        current.next.next = temp;
        numNodes++;
    }

    public void addFirst(Object element) {
        Node current = head;
        head = new Node(element);
        head.next = current;
        numNodes++;
    }

    public Node get(int index) {
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.println(current.elements);
            current = current.next;
        }
    }
}
