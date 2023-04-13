package com.beastlymc.data.array;

/**
 * A generic array implementation in Java that can hold elements of any type.
 *
 * @param <E> The type of elements stored in the array.
 *
 * @see com.beastlymc.data.array.AbstractArray
 */
public class Array<E> extends AbstractArray<E> {
    private final E[] arr;
    private int size;

    public Array(final int capacity) {
        super(capacity);
        size = 0;
        arr = (E[]) new Object[capacity];
    }

    @Override
    public E[] toArray() {
        return arr;
    }

    /**
     * Appends the specified element in this array.
     *
     * @param element The element to be appended.
     *
     * @throws IndexOutOfBoundsException if the array is full
     */
    @Override
    public void add(E element) {
        if (size == arr.length) {
            throw new ArrayIndexOutOfBoundsException("The array is full");
        }

        arr[size] = element;
        size++;
    }

    @Override
    public E set(final int index, final E element) {
        if (index < 0 || index >= getCapacity()) {
            throw new IndexOutOfBoundsException(index);
        }

        E prev = arr[index];

        size = Math.max(index + 1, size);
        arr[index] = element;

        return prev;
    }

    @Override
    public E removeElement(final E element) {
        int index = indexOf(element);

        if (index != -1) {
            return remove(index);
        }
        throw new IllegalArgumentException("Can't find (" + element + ")");
    }

    @Override
    public E remove(final int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index);
        }

        E ret = arr[index];

        for (int i = index + 1; i < size; i++) {
            arr[i - 1] = arr[i];
        }

        size--;
        arr[size] = null;

        return ret;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        if(getSize() == 0) {
            return;
        }

        for (int i = 0; i < getSize(); i++) {
            arr[i] = null;
        }

        size = 0;
    }
}
