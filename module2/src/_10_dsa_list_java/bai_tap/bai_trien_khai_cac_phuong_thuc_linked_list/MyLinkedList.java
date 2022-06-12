package _10_dsa_list_java.bai_tap.bai_trien_khai_cac_phuong_thuc_linked_list;

public class MyLinkedList<E> {
    private Node head;
    private int numNodes = 0;

    public class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return data;
        }
    }

    public MyLinkedList() {
    }

    public void addFirst(E element) {
        //temp trỏ tới node đầu tiên hiện tại
        Node temp = head;
        head = new Node(element);
        head.next = temp;
        numNodes++;
    }

    public void addLast(E element) {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(element);
        numNodes++;
    }

    public void add(int index, E element) {
        if (index < 0 || index > numNodes) {
            throw new IndexOutOfBoundsException("Error index: " + index);
        }

        Node temp = head;
        Node holder;
        // chạy temp tới node phía trước liền kề node được add
        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        // lưu giá trị của node phía sau liền kề node được add
        holder = temp.next;
        temp.next = new Node(element);
        temp.next.next = holder;
        numNodes++;

    }

    public E get(int index) {
        if (index < 0 || index > numNodes) {
            throw new IndexOutOfBoundsException("Error index: " + index);
        }

        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return (E) temp.data;
    }

    public E getFirst() {
        return head != null ? (E) head.data : null;
    }

    public E getLast() {
        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }
        return (E) temp.data;
    }

    public void clear() {
        head = null;
        numNodes = 0;
    }

    public boolean contains(E element) {
        Node temp = head;
        while (temp.next != null) {
            if (temp.data.equals(element)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public int indexOf(E element) {
        Node temp = head;
        for (int i = 0; i < numNodes; i++) {
            if (temp.getData().equals(element)) {
                return i;
            }
            temp = temp.next;
        }
        return -1;
    }

    public E remove(int index) {
        if (index < 0 || index > numNodes) {
            throw new IndexOutOfBoundsException("Error index: " + index);
        }

        Node temp = head;
        Object data;

        if (index == 0) {
            data = head.data;
            head = head.next;
            numNodes--;
        } else {
            for (int i = 0; i < index - 1 && temp.next != null; i++) {
                temp = temp.next;
            }
            data = temp.next.data;
            temp.next = temp.next.next;
            numNodes--;
        }
        return (E) data;
    }

    public Boolean remove(E element) {
        if (head.data.equals(element)) {
            remove(0);
            return true;
        } else {
            Node temp = head;
            while (temp.next != null) {
                if (temp.data.equals(element)) {
                    temp.next = temp.next.next;
                    numNodes--;
                    return true;
                }
                temp = temp.next;
            }
        }
        return false;
    }

    public int size() {
        return numNodes;
    }

    public MyLinkedList<E> clone() {
        // kiểm tra linkedlist có phần tử không
        if (numNodes == 0) {
            throw new NullPointerException("linkedlist is null");
        } else {
            MyLinkedList<E> returnList = new MyLinkedList<E>();
            Node temp = head;
            returnList.addFirst((E) temp.data);
            temp = temp.next;
            while (temp.next != null) {
                returnList.addLast((E) temp.data);
                temp = temp.next;
            }
            return returnList;
        }
    }
}
