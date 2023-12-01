package ArrayList;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Arrays;

public class MyArrayList<E> implements Iterable<E> {
    private E[] data;
    private int size = 0;
    private static final int INIT_CAP = 1;

    // default constructor
    public MyArrayList() {
        this(INIT_CAP);
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illigal Capacity:" + initialCapacity);
        }
        data = (E[]) new Object[initialCapacity];
        size = 0;
    }

    public int size() {
        return size;
    }

    public E get(int index) {
        checkElementIndex(index);
        return data[index];
    }

    public E set(int index, E e) {
        checkElementIndex(index);

        E oldVal = data[index];

        data[index] = e;

        return oldVal;
    }

    public void addLast(E item) {
        if (size == data.length) {
            resize(size * 2);
        }
        data[size] = item;
        size++;
    }

    public void add(int index, E e) {
        checkPositionIndex(index);

        if (size == data.length) {
            resize(size * 2);
        }

        System.arraycopy(data, index, data, index + 1, size - index);

        data[index] = e;

        size++;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public E removeLast() {
        if (size == 0) {
            throw new NoSuchElementException("error");
        }

        E deletedItem = data[size - 1];
        data[size - 1] = null;
        size--;

        return deletedItem;
    }

    public E remove(int index) {
        checkElementIndex(index);

        E deletedItem = data[index];

        System.arraycopy(data, index + 1, data, index, size - index - 1);

        data[size - 1] = null;

        return deletedItem;
    }

    public E removeFirst() {
        return remove(0);
    }

    public void printList() {
        if (size == 0) {
            throw new NoSuchElementException("error");
        }

        for (int i = 0; i < size; i++) {
            System.out.println(data[i] + " ");
        }
    }


    private void resize(int newSize) {
        if (size > newSize) {
            return;
        }

        E[] temp = Arrays.copyOf(data, newSize);

        data = temp;
    }

    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index)) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index)) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int p = 0;

            @Override
            public boolean hasNext() {
                return p != size;
            }

            @Override
            public E next() {
                return data[p++];
            }
        };
    }
}
