package com.beastlymc.data.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbstractArrayTest {

    private static Vector<Integer> vector = new Vector<>(5);
    private static Array<Integer> array = new Array<>(5);

    private static void restartVector() {
        vector = new Vector<>(5);
        vector.add(1);
        vector.add(2);
        vector.add(3);
        vector.add(4);
        vector.add(5);
    }

    private static void restartArray() {
        array = new Array<>(5);
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
    }

    private void testCapacityAndSize(AbstractArray<Integer> abstractArray, int size, int capacity) {
        assertEquals(capacity, abstractArray.getCapacity());
        assertEquals(size, abstractArray.getSize());
    }

    static {
        restartArray();
        restartVector();
    }

    @Test
    void isEmpty() {
        Array<Integer> emptyArray = new Array<>(5);

        assertTrue(emptyArray.isEmpty());
    }

    @Test
    void contains() {
        assertTrue(array.contains(2));
        assertFalse(vector.contains(20));
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

        restartArray();
        restartVector();
    }

    @Test
    void toArray() {
        Integer[] ints = new Integer[5];
        ints[0] = 1;
        ints[1] = 2;
        ints[2] = 3;
        ints[3] = 4;

        assertArrayEquals(ints, array.toArray());
        assertEquals(ints.length, array.getCapacity());

        ints[4] = 5;

        assertArrayEquals(ints, vector.toArray());
        assertEquals(ints.length, vector.getCapacity());
    }

    @Test
    void add() {
        testCapacityAndSize(vector, 5, 5);
        testCapacityAndSize(array, 4, 5);

        vector.add(100);
        array.add(5);

        assertEquals(5, array.get(4));
        testCapacityAndSize(array, 5, 5);
        assertThrows(IndexOutOfBoundsException.class, () -> array.add(2));

        assertEquals(100, vector.get(5));
        testCapacityAndSize(vector, 6, 10);


        restartArray();
        restartVector();
    }

    @Test
    void set() {
        testCapacityAndSize(vector, 5, 5);
        testCapacityAndSize(array, 4, 5);

        assertEquals(1, array.set(0, 10));
        assertEquals(1, vector.set(0, 20));

        testCapacityAndSize(array, 4, 5);
        testCapacityAndSize(vector, 5, 5);

        assertEquals(10, array.get(0));
        assertEquals(20, vector.get(0));

        array.set(4, 50);
        vector.set(5, 100);

        testCapacityAndSize(array, 5, 5);
        testCapacityAndSize(vector, 6, 10);

        assertEquals(50, array.get(4));
        assertEquals(100, vector.get(5));

        assertThrows(IndexOutOfBoundsException.class, () -> array.set(5, 999));
        assertThrows(IndexOutOfBoundsException.class,
                     () -> vector.set(-1, 999));

        restartVector();
        restartArray();
    }

    @Test
    void removeElement() {
        testCapacityAndSize(vector, 5, 5);
        testCapacityAndSize(array, 4, 5);

        array.removeElement(3);
        vector.removeElement(4);

        testCapacityAndSize(vector, 4, 5);
        testCapacityAndSize(array, 3, 5);

        assertThrows(IllegalArgumentException.class,
                     () -> array.removeElement(5));
        assertThrows(IllegalArgumentException.class,
                     () -> vector.removeElement(20));

        restartVector();
        restartArray();
    }

    @Test
    void remove() {
        testCapacityAndSize(vector, 5, 5);
        testCapacityAndSize(array, 4, 5);

        array.remove(0);
        vector.remove(0);


        testCapacityAndSize(array, 3, 5);
        testCapacityAndSize(vector, 4, 5);

        array.remove(0);
        array.remove(0);
        array.remove(0);

        vector.remove(0);
        vector.remove(0);
        vector.remove(0);

        testCapacityAndSize(array, 0, 5);
        testCapacityAndSize(vector, 1, 2);

        assertThrows(IndexOutOfBoundsException.class, () -> array.remove(20));
        assertThrows(IndexOutOfBoundsException.class, () -> vector.remove(20));

        restartArray();
        restartVector();
    }

}
