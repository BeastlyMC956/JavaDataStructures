package com.beastlymc.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    void testLinkedListOperations() {
        LinkedList<Integer> list = new LinkedList<>();

        assertTrue(list.isEmpty());
        assertEquals(0, list.getSize());

        list.add(1);
        list.add(2);
        list.add(3);

        assertFalse(list.isEmpty());
        assertEquals(3, list.getSize());

        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));

        list.addFirst(0);
        assertEquals(0, list.get(0));
        assertEquals(1, list.get(1));
        assertEquals(4, list.getSize());

        assertTrue(list.contains(2));
        assertFalse(list.contains(5));

        list.set(1, 7);
        assertEquals(7, list.get(1));

        list.remove(0);
        assertEquals(3, list.getSize());
        assertEquals(7, list.get(0));

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(3));
    }

}