package com.beastlymc.data.arrays;

/**
 * A resizable array implementation of a vector that can hold elements of any
 * type.
 *
 * @param <E> the type of elements in the vector
 *
 * @see AbstractArray
 */
public class Vector<E> extends AbstractArray<E> {

    private E[] arr;
    private int size;

    public Vector(final int capacity) {
        super(capacity);
        size = 0;
        this.arr = (E[]) new Object[capacity];
    }

    @Override
    public int getCapacity() {
        return arr.length;
    }

    @Override
    public synchronized E[] toArray() {
        return arr;
    }

    /**
     * Appends the specified element in this array. Resizes the Array as needed
     *
     * @param element The element to be appended.
     */
    @Override
    public synchronized void add(final E element) {
        if (size == arr.length) {
            resize(2 * arr.length);
        }

        arr[size] = element;
        size++;
    }

    /**
     * Resizes the array to the specified new capacity.
     *
     * @param newCapacity The new capacity of the array.
     */
    private synchronized void resize(final int newCapacity) {
        E[] newArray = (E[]) new Object[newCapacity];

        if (size >= 0) {
            System.arraycopy(arr, 0, newArray, 0, size);
        }

        arr = newArray;
    }

    /**
     * Sets the value of the element at the specified index.
     *
     * @param index   The index of the element to set.
     * @param element The new element to be inserted.
     *
     * @throws IndexOutOfBoundsException If the index is negative
     */
    @Override
    public synchronized E set(final int index, final E element) {
        if (index < 0) {
            throw new IndexOutOfBoundsException(index);
        }

        if (index >= getCapacity()) {
            resize(2 * getCapacity());
        }
        E prev = arr[index];

        size = Math.max(index + 1, size);
        arr[index] = element;

        return prev;
    }

    @Override
    public synchronized E removeElement(final E element) {
        int index = indexOf(element);

        if (index != -1) {
            return remove(index);
        }
        throw new IllegalArgumentException("Can't find (" + element + ")");
    }

    @Override
    public synchronized E remove(final int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index);
        }

        E ret = arr[index];

        for (int i = index + 1; i < size; i++) {
            arr[i - 1] = arr[i];
        }

        size--;
        arr[size] = null;

        if (size == arr.length / 4 && arr.length / 2 != 0) {
            resize(arr.length / 2);
        }

        return ret;
    }

    @Override
    public synchronized int getSize() {
        return size;
    }

    @Override
    public synchronized void clear() {
        if (getSize() == 0) {
            return;
        }

        for (int i = 0; i < getSize(); i++) {
            arr[i] = null;
        }

        size = 0;
    }
}
