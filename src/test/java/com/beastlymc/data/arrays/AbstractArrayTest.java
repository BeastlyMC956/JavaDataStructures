package com.beastlymc.data.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class AbstractArrayTest {

    private static AbstractArray<Integer> vector = new Vector<>(5);
    private static AbstractArray<Integer> array = new Array<>(5);

    @BeforeEach
    void init() {
        vector = new Vector<>(5);
        array = new Array<>(5);

        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);

        vector.add(1);
        vector.add(2);
        vector.add(3);
        vector.add(4);
        vector.add(5);
    }

    private void testCapacityAndSize(final AbstractArray<Integer> abstractArray, final int size, final int capacity) {
        assertEquals(capacity, abstractArray.length());
        assertEquals(size, abstractArray.size());
    }

    @Test
    void isEmpty() {
        AbstractArray<Integer> emptyArray = new Array<>(5);
        AbstractArray<Integer> emptyVector = new Vector<>(5);

        assertTrue(emptyArray.isEmpty());
        assertTrue(emptyVector.isEmpty());
        assertEquals(-1, emptyArray.indexOf(20));
        assertEquals(-1, emptyVector.indexOf(20));
    }

    @Test
    void contains() {
        assertTrue(array.contains(2));
        assertFalse(vector.contains(20));
    }

    @Test
    void testIterator() {
        assertTrue(array.iterator().hasNext());

        int index = 0;
        for (Integer ints : array) {
            assertEquals(ints, array.get(index));
            index++;
        }

        index = 0;
        for (Integer ints : vector) {
            assertEquals(ints, vector.get(index));
            index++;
        }
    }

    @Test
    void stringTest() {
        Vector<Integer> newVector = new Vector<>(5);
        newVector.add(1);
        newVector.add(2);
        newVector.add(3);
        newVector.add(4);
        newVector.add(5);
        assertEquals(newVector.toString(), vector.toString());
    }

    @Test
    void get() {
        assertEquals(1, vector.get(0));
        assertEquals(4, array.get(3));

        assertThrows(IndexOutOfBoundsException.class, () -> array.get(20));
    }

    @Test
    void clear() {
        testCapacityAndSize(array, 4, 5);
        testCapacityAndSize(vector, 5, 5);

        array.clear();
        vector.clear();

        testCapacityAndSize(array, 0, 5);
        testCapacityAndSize(vector, 0, 5);
    }

    @Test
    void toArray() {
        Integer[] ints = new Integer[5];
        ints[0] = 1;
        ints[1] = 2;
        ints[2] = 3;
        ints[3] = 4;

        assertArrayEquals(ints, array.toArray());
        assertEquals(ints.length, array.length());

        ints[4] = 5;

        assertArrayEquals(ints, vector.toArray());
        assertEquals(ints.length, vector.length());
    }

    @Test
    void add() {
        testCapacityAndSize(vector, 5, 5);
        testCapacityAndSize(array, 4, 5);

        array.add(5);

        assertEquals(5, array.get(4));
        testCapacityAndSize(array, 5, 5);
        assertThrows(IndexOutOfBoundsException.class, () -> array.add(2));
        assertThrows(IndexOutOfBoundsException.class, () -> vector.add(100));

        assertEquals(5, vector.get(4));
        testCapacityAndSize(vector, 5, 5);
    }

    @Test
    void set() {
        testCapacityAndSize(array, 4, 5);
        testCapacityAndSize(vector, 5, 5);

        assertEquals(1, array.get(0));
        assertEquals(1, vector.get(0));

        array.insert(4, 50);
        vector.insert(4, 100);

        testCapacityAndSize(array, 5, 5);
        testCapacityAndSize(vector, 5, 5);

        assertEquals(50, array.get(4));
        assertEquals(100, vector.get(4));

        assertThrows(IndexOutOfBoundsException.class,
                     () -> array.insert(5, 999));
        assertThrows(IndexOutOfBoundsException.class,
                     () -> vector.insert(-1, 999));
    }

    @Test
    void removeElement() {
        testCapacityAndSize(vector, 5, 5);
        testCapacityAndSize(array, 4, 5);

        array.remove(3);
        vector.remove(4);

        testCapacityAndSize(vector, 4, 5);
        testCapacityAndSize(array, 3, 5);

        assertEquals(Optional.empty(), array.remove(5));
        assertEquals(Optional.empty(), vector.remove(20));
    }

    @Test
    void remove() {
        testCapacityAndSize(vector, 5, 5);
        testCapacityAndSize(array, 4, 5);

        array.removeAt(0);
        vector.removeAt(0);

        testCapacityAndSize(array, 3, 5);
        testCapacityAndSize(vector, 4, 5);

        array.removeAt(0);
        array.removeAt(0);
        array.removeAt(0);

        vector.removeAt(0);
        vector.removeAt(0);
        vector.removeAt(0);

        testCapacityAndSize(array, 0, 5);
        testCapacityAndSize(vector, 1, 5);

        assertEquals(Optional.empty(), array.remove(20));
        assertEquals(Optional.empty(), vector.remove(20));
    }

}
