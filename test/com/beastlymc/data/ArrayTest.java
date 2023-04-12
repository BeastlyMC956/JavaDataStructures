package com.beastlymc.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayTest {

    @Test
    void testArrayOperations() {
        Array<Integer> array = new Array<>(4);

        assertTrue(array.isEmpty());
        assertEquals(4, array.getCapacity());

        array.addLast(1);
        array.addLast(2);
        array.addLast(3);

        assertEquals(3, array.getSize());
        assertFalse(array.isEmpty());
        assertEquals(4, array.getCapacity());

        array.addFirst(0);
        assertEquals(0, array.get(0));

        assertThrows(IndexOutOfBoundsException.class, () -> array.set(20, 5));
        assertThrows(IndexOutOfBoundsException.class, () -> array.get(20));
        assertThrows(IndexOutOfBoundsException.class, () -> array.add(20, 5));

        // Set Test
        array.set(2, 5);
        assertEquals(5, array.get(2));

        // Resize Check
        array.addLast(9);
        assertEquals(8, array.getCapacity());

        assertFalse(array.contains(20));
        assertEquals(-1, array.indexOf(20));

        assertTrue(array.contains(5));
        assertEquals(2, array.indexOf(5));

        array.remove(1);
        assertEquals(4, array.getSize());

        array.removeFirst();
        assertEquals(3, array.getSize());

        array.removeLast();
        assertEquals(2, array.getSize());
        assertEquals(4, array.getCapacity());

        array.removeElement(3);
        assertEquals(1, array.getSize());

        assertEquals(2, array.getCapacity());

        Array<Integer> firstArray = new Array<>();
        Array<Integer> secondArray = new Array<>();
        assertEquals(8, firstArray.getCapacity());

        assertEquals(firstArray, secondArray);
        assertEquals(firstArray.hashCode(), secondArray.hashCode());

    }
}