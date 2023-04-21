package com.beastlymc.data.arrays;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * The Array class is a fixed-size array that extends the {@link AbstractArray}
 * class and implementing the {@link com.beastlymc.data.common.Insertable}
 * interface. It provides methods for inserting, removing, and querying elements
 * in the array. The class is parameterized over a type E, which represents the
 * type of elements stored in the array.
 *
 * @param <E> the type of elements stored in the Array
 */
public class Array<E> extends AbstractArray<E> {

    /**
     * The current size of the array
     */
    private int size;

    /**
     * Constructs a new Array object with the specified capacity.
     *
     * @param capacity the capacity of the array
     */
    public Array(final int capacity) {
        super(capacity);
        size = 0;
    }

    @Override
    public void insert(final int index, final E element) throws IndexOutOfBoundsException {
        if (index < 0 || index >= array.length) {
            throw new IndexOutOfBoundsException(index);
        }

        size = Math.max(size, index + 1);
        array[index] = element;
    }

    @Override
    public Optional<E> removeAt(final int index) {
        size--;
        return super.removeAt(index);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        int length = length();
        array = (E[]) new Object[length];
        size = 0;
    }

    @Override
    public E[] toArray() {
        return array;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator<>(this);
    }


    /**
     * The ArrayIterator class is an iterator over the elements in the Array
     * class.
     */
    private static class ArrayIterator<E> implements Iterator<E> {
        /**
         * The Array to iterate over
         */
        private final Array<E> array;

        /**
         * The current index in the Array
         */
        private int index;

        /**
         * Constructs a new ArrayIterator object with the specified capacity.
         *
         * @param capacity the capacity of the Array
         */
        public ArrayIterator(Array<E> array) {
            this.array = array;
            index = 0;
        }

        /**
         * @return true if the Array has more elements to iterate over, false
         * otherwise
         */
        @Override
        public boolean hasNext() {
            return index != array.size();
        }

        /**
         * Returns the next element in the Array and advances the iterator.
         *
         * @return the next element in the Array
         *
         * @throws NoSuchElementException if there are no more elements to
         *                                iterate over
         */
        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            E data = array.get(index);
            index++;
            return data;
        }
    }
}
