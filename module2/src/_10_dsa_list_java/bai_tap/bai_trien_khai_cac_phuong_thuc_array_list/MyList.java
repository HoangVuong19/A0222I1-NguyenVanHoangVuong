package _10_dsa_list_java.bai_tap.bai_trien_khai_cac_phuong_thuc_array_list;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;

    public MyList() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        elements = (E[]) new Object[capacity];
    }

    public void add(int index, E element) {
        if (index < 0 || index > elements.length - 1) {
            System.out.println("Invalid input index");
        }
        elements[index] = element;
        if (elements[index] == null) {
            size++;
        }
        ensureCapacity();

    }


    private void ensureCapacity() {
        if (size >= elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
    }

    public int getSize() {
        return size;
    }
}
