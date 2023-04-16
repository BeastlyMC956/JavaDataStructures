package com.beastlymc.data.array;

/**
 * An implementation of the {@link AbstractArray} class that uses a plain fixed
 * array to store elements.
 *
 * @param <E> the type of elements stored in the array.
 */
public class Array<E> extends AbstractArray<E> {

    /**
     * The backing array for the elements stored in this instance.
     */
    private final E[] arr;

    /**
     * The current size of this instance, i.e. the number of elements it
     * contains.
     */
    private int size;

    /**
     * Constructs a new Array instance with the specified capacity.
     *
     * @param capacity the capacity of the array.
     */
    public Array(final int capacity) {
        super(capacity);
        size = 0;
        arr = (E[]) new Object[capacity];
    }

    /**
     * Returns an array containing all the elements in this instance in proper
     * sequence.
     *
     * @return an array containing all the elements in this instance.
     */
    @Override
    public E[] toArray() {
        return arr;
    }

    /**
     * Appends the specified element to the end of this instance.
     *
     * @param element the element to add.
     *
     * @throws ArrayIndexOutOfBoundsException if the array is full.
     */
    @Override
    public void add(E element) {
        if (size == arr.length) {
            throw new ArrayIndexOutOfBoundsException("The array is full");
        }

        arr[size] = element;
        size++;
    }

    /**
     * Replaces the element at the specified position in this instance with the
     * specified element.
     *
     * @param index   the index of the element to replace.
     * @param element the element to be stored at the specified position.
     *
     * @return the element previously at the specified position.
     *
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0
     *                                   || index >= capacity).
     */
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

    /**
     * Removes the first occurrence of the specified element from this instance,
     * if it is present.
     *
     * @param element the element to be removed from this instance, if present.
     *
     * @return the removed element if it was present
     *
     * @throws IllegalArgumentException if the element can't be found
     */
    @Override
    public E removeElement(final E element) {
        int index = indexOf(element);

        if (index != -1) {
            return remove(index);
        }
        throw new IllegalArgumentException("Can't find (" + element + ")");
    }

    /**
     * Removes the element at the specified position in this instance.
     *
     * @param index the index of the element to be removed.
     *
     * @return the element previously at the specified position.
     *
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0
     *                                   || index >= size).
     */
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

    /**
     * @return the number of elements in this instance.
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * Removes all the elements from this instance.
     */
    @Override
    public void clear() {
        if (getSize() == 0) {
            return;
        }

        for (int i = 0; i < getSize(); i++) {
            arr[i] = null;
        }

        size = 0;
    }
}
