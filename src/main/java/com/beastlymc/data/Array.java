package com.beastlymc.data;

import java.util.Arrays;
import java.util.Objects;

/**
 * A dynamic array implementation in Java.
 * The array resizes itself automatically when necessary.
 *
 * @param <E> The type of elements stored in the array.
 */
public class Array<E> {
    private int size;
    private E[] arr;

    /**
     * Constructs an empty array with an initial capacity of 8.
     */
    public Array() {
        this(8);
    }

    /**
     * Constructs an empty array with the specified capacity.
     *
     * @param capacity The initial capacity of the array.
     */
    public Array(int capacity) {
        this.arr = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * Returns the number of elements currently stored in the array.
     *
     * @return The number of elements in the array.
     */
    public int getSize() {
        return size;
    }

    /**
     * Returns the current capacity of the array.
     *
     * @return The current capacity of the array.
     */
    public int getCapacity() {
        return arr.length;
    }

    /**
     * Checks if the array is empty.
     *
     * @return True if the array is empty, false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Gets the element at the specified index.
     *
     * @param index The index of the element to get.
     *
     * @return The element at the specified index.
     *
     * @throws IndexOutOfBoundsException If the index is out of bounds.
     */
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(index);
        }
        return arr[index];
    }


    /**
     * Sets the value of the element at the specified index.
     *
     * @param index The index of the element to set.
     * @param value The new value of the element.
     *
     * @throws IndexOutOfBoundsException If the index is out of bounds.
     */
    public void set(int index, E value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index);
        }
        arr[index] = value;
    }

    /**
     * Inserts the specified element at the specified position in this array.
     *
     * @param index   The index at which the element should be inserted.
     * @param element The element to be inserted.
     *
     * @throws IndexOutOfBoundsException If the index is out of bounds.
     */
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(index);
        }

        if (size == arr.length) {
            resize(2 * arr.length);
        }

        for (int i = size - 1; i >= index; i--) {
            arr[i + 1] = arr[i];
        }

        arr[index] = element;
        size++;
    }

    /**
     * Appends the specified element to the end of this array.
     *
     * @param element The element to be appended.
     */
    public void addLast(E element) {
        add(size, element);
    }

    /**
     * Inserts the specified element at the beginning of this array.
     *
     * @param element The element to be inserted.
     */
    public void addFirst(E element) {
        add(0, element);
    }

    /**
     * Removes the element at the specified index from this array.
     *
     * @param index The index of the element to be removed.
     *
     * @return The element that was removed from the array.
     *
     * @throws IndexOutOfBoundsException If the index is out of bounds.
     */
    public E remove(int index) {
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

    /**
     * Removes the first element from this array.
     *
     * @return The element that was removed from the array.
     *
     * @throws IndexOutOfBoundsException If the array is empty.
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * Removes the last element from this array.
     *
     * @return The element that was removed from the array.
     *
     * @throws IndexOutOfBoundsException If the array is empty.
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * Checks if the array contains the specified element.
     *
     * @param element The element to check for.
     *
     * @return True if the array contains the element, false otherwise.
     */
    public boolean contains(E element) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(element)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Returns the index of the first occurrence of the specified element in this array, or -1 if the array does not contain the element.
     *
     * @param element The element to search for.
     *
     * @return The index of the first occurrence of the element, or -1 if the element is not found.
     */
    public int indexOf(E element) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(element)) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Removes the first occurrence of the specified element from this array.
     *
     * @param element The element to remove.
     */
    public void removeElement(E element) {
        int index = indexOf(element);

        if (index != -1) {
            remove(index);
        }
    }

    /**
     * Resizes the array to the specified new capacity.
     *
     * @param newCapacity The new capacity of the array.
     */
    private void resize(int newCapacity) {
        E[] newArray = (E[]) new Object[newCapacity];

        if (size >= 0) {
            System.arraycopy(arr, 0, newArray, 0, size);
        }

        arr = newArray;
    }

    /**
     * Returns true if this array is equal to the specified object.
     *
     * @param o The object to compare with.
     *
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Array<?> array = (Array<?>) o;
        return size == array.size && getCapacity() == array.getCapacity() && Arrays.equals(arr, array.arr);
    }

    /**
     * @return A hash code for this array.
     */
    @Override
    public int hashCode() {
        int result = Objects.hash(size, getCapacity());
        result = 31 * result + Arrays.hashCode(arr);
        return result;
    }

    /**
     * @return A string representation of this array.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Array size = %d, capacity = %d%n", size, arr.length));
        sb.append("[");

        for (int i = 0; i < size; i++) {
            sb.append(arr[i]);

            if (i != size - 1) {
                sb.append(", ");
            }
        }

        sb.append("]");

        return sb.toString();
    }
}
