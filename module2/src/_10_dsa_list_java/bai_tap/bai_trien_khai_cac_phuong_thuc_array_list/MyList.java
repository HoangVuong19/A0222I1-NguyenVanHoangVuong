package _10_dsa_list_java.bai_tap.bai_trien_khai_cac_phuong_thuc_array_list;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;


    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        if (capacity > 0) {
            elements = new Object[capacity];
        } else {
            throw new IllegalArgumentException("capacity error:" + capacity);
        }
    }

    public void add(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
        }

        ensureCapacity();
        for (int i = size + 1; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
    }

    public E remove(int index) {
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }

        elements[size] = null;
        size--;
        return (E) elements[index];
    }

    public int size() {
        return size;
    }

    public MyList<E> clone() {
        if (size == 0) {
            throw new NullPointerException("arraylist is null");
        } else {
            MyList<E> retList = new MyList<>();
            retList.elements = Arrays.copyOf(elements, size);
            retList.size = this.size;
            return retList;
        }
    }

    public boolean contains(E element) {
        return indexOf(element) > 0;
    }

    public int indexOf(E element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public boolean add(E element) {
        elements[size] = element;
        size++;
        return true;
    }

    private void ensureCapacity() {
        if (size >= elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 3 / 2);
        }
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        return (E) elements[index];
    }

    public void clear() {
        size = 0;
        for (int i = 0; i < elements.length; i++) {
            elements[i] = null;
        }
    }
}
