package com.beastlymc.data.arrays;


import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * The Vector class is a thread-safe implementation of a fixed size array that
 * extends the {@link AbstractArray} class and implements the
 * {@link com.beastlymc.data.common.Insertable} interface. It provides methods
 * for inserting, removing, and querying elements in the array. The class is
 * parameterized over a type E, which represents the type of elements stored in
 * the array.
 *
 * @param <E> the type of elements stored in the Vector
 */
public class Vector<E> extends AbstractArray<E> {

    /**
     * The current size of the array
     */
    private volatile int size;

    /**
     * Constructs a new Vector object with the specified capacity.
     *
     * @param capacity the capacity of the array
     */
    public Vector(final int capacity) {
        super(capacity);
        size = 0;
    }

    @Override
    public synchronized E[] toArray() {
        return array;
    }

    @Override
    public synchronized E get(final int index) {
        return super.get(index);
    }

    @Override
    public synchronized boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    public synchronized void insert(final int index, final E element) {
        if (index < 0 || index >= array.length) {
            throw new IndexOutOfBoundsException(index);
        }

        size = Math.max(index + 1, size);
        array[index] = element;
    }

    @Override
    public synchronized void add(final E element) {
        super.add(element);
    }

    @Override
    public synchronized Optional<E> remove(final E element) {
        return super.remove(element);
    }

    @Override
    public synchronized Optional<E> removeAt(final int index) {
        size--;
        return super.removeAt(index);
    }

    @Override
    public synchronized boolean contains(final E element) {
        return super.contains(element);
    }

    @Override
    public synchronized int indexOf(final E element) {
        return super.indexOf(element);
    }

    @Override
    public synchronized int length() {
        return super.length();
    }

    @Override
    public synchronized int size() {
        return size;
    }

    @Override
    public synchronized void clear() {
        int length = length();
        array = (E[]) new Object[length];
        size = 0;
    }

    @Override
    public synchronized Iterator<E> iterator() {
        return new VectorIterator<>(this);
    }

    @Override
    public synchronized String toString() {
        return super.toString();
    }

    /**
     * The VectorIterator class is an iterator over the elements in the Vector
     * class.
     */
    private static class VectorIterator<E> implements Iterator<E> {
        /**
         * The Vector to iterate over
         */
        private final Vector<E> vector;
        /**
         * The current index in the Vector
         */
        private int index;

        /**
         * Constructs a new VectorIterator object with the specified capacity.
         *
         * @param capacity the capacity of the Vector
         */
        public VectorIterator(Vector<E> vector) {
            this.vector = vector;
            index = 0;
        }

        /**
         * @return true if the Vector has more elements to iterate over, false
         * otherwise
         */
        @Override
        public synchronized boolean hasNext() {
            return index != vector.size();
        }

        /**
         * Returns the next element in the Vector and advances the iterator.
         *
         * @return the next element in the Vector
         *
         * @throws NoSuchElementException if there are no more elements to
         *                                iterate over
         */
        @Override
        public synchronized E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            E data = vector.get(index);
            index++;
            return data;
        }
    }
}
