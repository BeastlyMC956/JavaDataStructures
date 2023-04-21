package com.beastlymc.data.arrays;

import com.beastlymc.data.common.Insertable;

import java.util.Optional;

/**
 * The AbstractArray class is an abstract base class that implements the
 * {@link Insertable} interface. It provides a basic implementation of an array
 * that can be inserted, removed, and queried. The class is parameterized over a
 * type E, which represents the type of elements stored in the array.
 *
 * @param <E> the type of elements stored in the Array
 */
public abstract class AbstractArray<E> implements Insertable<E> {

    /**
     * The array of elements
     */
    protected E[] array;

    /**
     * Constructs a new AbstractArray object with the specified capacity.
     *
     * @param capacity the capacity of the array
     */
    protected AbstractArray(final int capacity) {
        array = (E[]) new Object[capacity];
    }

    /**
     * Returns the element at the specified index in the array.
     *
     * @param index the index of the element to return
     *
     * @return the element at the specified index
     *
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public E get(int index) {
        if (index < 0 || index >= toArray().length) {
            throw new IndexOutOfBoundsException(index);
        }

        return array[index];
    }

    /**
     * Removes the first occurrence of the specified element from the array.
     *
     * @param element the element to be removed from the array
     *
     * @return an {@link Optional} containing the removed element, or an empty
     * Optional if the element was not found
     */
    @Override
    public Optional<E> remove(final E element) {
        if (indexOf(element) == -1) {
            return Optional.empty();
        }

        return removeAt(indexOf(element));
    }

    /**
     * Removes the element at the specified index from the array.
     *
     * @param index the index of the element to be removed from the array
     *
     * @return an {@link Optional} containing the removed element, or an empty
     * Optional if the element was not found
     *
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public Optional<E> removeAt(final int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= array.length) {
            throw new IndexOutOfBoundsException(index);
        }

        if (array[index] == null) {
            return Optional.empty();
        }

        E element = array[index];
        array[index] = null;

        return Optional.of(element);
    }

    /**
     * Returns the length of the array
     *
     * @return the length of the array
     */
    public int length() {
        return array.length;
    }

    /**
     * Returns true if the array contains the specified element, false
     * otherwise.
     *
     * @param element the element to be searched for in the array
     *
     * @return true if the array contains the specified element, false otherwise
     */
    @Override
    public boolean contains(final E element) {
        for (E ele : toArray()) {
            if (ele == null) {
                continue;
            }
            if (ele.equals(element)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the index of the first occurrence of the specified element in the
     * array.
     *
     * @param element the element to be searched for in the array
     *
     * @return the index of the first occurrence of the specified element in the
     * array, or -1 if the element was not found
     */
    public int indexOf(final E element) {
        if (!contains(element)) {
            return -1;
        }

        for (int i = 0; i < array.length; i++) {
            if (toArray()[i].equals(element)) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Returns an array containing all the elements in the array
     *
     * @return an array containing all the elements in the array
     */
    public abstract E[] toArray();

    /**
     * @return a string representation of the array
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        int index = 0;
        for (E element : this) {
            if (element != null) {
                if (index == size() - 1) {
                    return sb.append(element).append("]").toString();
                }
                sb.append(element).append(",");
            }
            index++;
        }

        sb.append("]");
        return sb.toString();
    }
}
