package com.beastlymc.data.hash;

import com.beastlymc.data.arrays.Array;

/**
 * This class implements a hash table that can store any type of value.
 *
 * @param <V> the type of value to be stored in the hash table
 */
public class HashTable<V> {

    private int size;
    private int capacity;
    private Array<V> arr;

    /**
     * Constructs a new hash table with the given capacity.
     *
     * @param capacity the initial capacity of the hash table
     */
    public HashTable(final int capacity) {
        this.capacity = findNextPrime(capacity * 2);
        this.arr = new Array<>(this.capacity);
        this.size = 0;
    }

    /**
     * Checks whether the given number is prime.
     *
     * @param number the number to be checked
     *
     * @return true if the number is prime, false otherwise
     */
    private boolean isPrime(final int number) {
        if (number % 2 == 0) {
            return false;
        }

        for (int i = 3; i * i <= number; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * Finds the next prime number greater than or equal to the given minimum
     * number.
     *
     * @param minimumNumber the minimum number
     *
     * @return the next prime number greater than or equal to the minimum number
     */
    private int findNextPrime(final int minimumNumber) {
        for (int i = minimumNumber; true; i++) {
            if (isPrime(i)) {
                return i;
            }
        }
    }

    /**
     * Checks whether the hash table is empty.
     *
     * @return true if the hash table is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @return the size of the {@link HashTable}
     */
    public int getSize() {
        return size;
    }

    /**
     * @return The current capacity of the {@link HashTable}.
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Returns a positive hash index for the given key.
     *
     * @param key the key to be hashed
     *
     * @return the hash index for the given key
     */
    private int getHashIndex(final V key) {
        int code = key.hashCode();

        code = code & 0x7fffffff;

        return code % capacity;
    }

    /**
     * Puts the given value into the hash table.
     *
     * @param value the value to be put into the hash table
     */
    public void put(final V value) {
        if (size == capacity) {
            resize();
        }

        int index = getHashIndex(value);

        while (arr.get(index) != null) {
            index++;

            index %= capacity;
        }

        arr.set(index, value);
        size++;
    }

    /**
     * Puts the values from the given array into the hash table.
     *
     * @param arrayValues the array of values to be put into the hash table
     */
    public void putArray(final V[] arrayValues) {
        for (V elementValue : arrayValues) {
            put(elementValue);
        }
    }

    /**
     * Returns the index of the given value in the hash table, or -1 if the
     * value is not found.
     *
     * @param value the value to be searched for
     *
     * @return the index of the value in the hash table, or -1 if the value is
     * not found
     */
    public int getIndexForKey(final V value) {
        int indexHash = getHashIndex(value);

        for (int i = 0; i < capacity; i++) {
            if (arr.get(indexHash) != null &&
                arr.get(indexHash).equals(value)) {
                return indexHash;
            }
            indexHash++;
            indexHash %= capacity;
        }
        return -1;
    }

    /**
     * Resizes the hash table to twice its current capacity.
     */
    public void resize() {
        int newCapacity = capacity * 2;
        Array<V> newArray = new Array<>(newCapacity);

        for (int i = 0; i < capacity; i++) {
            V element = arr.get(i);
            if (element != null) {
                int newIndex = getHashIndex(element);
                while (newArray.get(newIndex) != null) {
                    newIndex = (newIndex + 1) % newCapacity;
                }
                newArray.set(newIndex, element);
            }
        }

        capacity = newCapacity;
        arr = newArray;
    }

    /**
     * @return a string representation of the hash table
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < capacity; i++) {
            V element = arr.get(i);
            String elementStr = element == null
                                ? " . . . "
                                : element.toString();
            sb.append(String.format("%d | %s%n", i, elementStr));
        }
        return sb.toString();
    }
}
