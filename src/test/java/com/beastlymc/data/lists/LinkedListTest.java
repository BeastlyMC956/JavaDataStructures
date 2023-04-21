package com.beastlymc.data.lists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    private LinkedList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new LinkedList<>();
    }

    @Test
    void testAppend() {
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());

        list.add(1);
        assertFalse(list.isEmpty());
        assertEquals(1, list.size());
        assertEquals(1, list.get(0));

        list.add(2);
        assertFalse(list.isEmpty());
        assertEquals(2, list.size());
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
    }

    @Test
    void testAddFirst() {
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());

        list.addFirst(1);
        assertFalse(list.isEmpty());
        assertEquals(1, list.size());
        assertEquals(1, list.get(0));

        list.addFirst(2);
        assertFalse(list.isEmpty());
        assertEquals(2, list.size());
        assertEquals(2, list.get(0));
        assertEquals(1, list.get(1));
    }

    @Test
    void testInsert() {
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());

        list.insert(0, 1);
        assertFalse(list.isEmpty());
        assertEquals(1, list.size());
        assertEquals(1, list.get(0));

        list.insert(0, 2);
        assertFalse(list.isEmpty());
        assertEquals(2, list.size());
        assertEquals(2, list.get(0));
        assertEquals(1, list.get(1));

        list.insert(1, 3);
        assertFalse(list.isEmpty());
        assertEquals(3, list.size());
        assertEquals(2, list.get(0));
        assertEquals(3, list.get(1));
        assertEquals(1, list.get(2));

        list.insert(3, 4);
        assertFalse(list.isEmpty());
        assertEquals(4, list.size());
        assertEquals(2, list.get(0));
        assertEquals(3, list.get(1));
        assertEquals(1, list.get(2));
        assertEquals(4, list.get(3));
    }

    @Test
    void testRemove() {
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());

        Optional<Integer> removed = list.remove(1);
        assertTrue(removed.isEmpty());
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());

        list.add(1);
        list.add(2);
        list.add(3);

        removed = list.remove(2);
        assertTrue(removed.isPresent());
        assertEquals(2, removed.get());
        assertFalse(list.isEmpty());
        assertEquals(2, list.size());
        assertEquals(1, list.get(0));
        assertEquals(3, list.get(1));

        removed = list.removeAt(1);
        assertTrue(removed.isPresent());
        assertEquals(3, removed.get());
        assertFalse(list.isEmpty());
        assertEquals(1, list.size());
        assertEquals(1, list.get(0));

        removed = list.removeAt(0);
        assertTrue(removed.isPresent());
        assertEquals(1, removed.get());
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());

        removed = list.remove(0);
        assertTrue(removed.isEmpty());
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    void testRemoveAt() {
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());

        assertThrows(IndexOutOfBoundsException.class, () -> list.removeAt(0));

        list.add(1);
        list.add(2);
        list.add(3);

        assertThrows(IndexOutOfBoundsException.class, () -> list.removeAt(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.removeAt(3));

        Optional<Integer> removed = list.removeAt(1);
        assertTrue(removed.isPresent());
        assertEquals(2, removed.get());
        assertFalse(list.isEmpty());
        assertEquals(2, list.size());
        assertEquals(1, list.get(0));
        assertEquals(3, list.get(1));

        removed = list.removeAt(0);
        assertTrue(removed.isPresent());
        assertEquals(1, removed.get());
        assertFalse(list.isEmpty());
        assertEquals(1, list.size());
        assertEquals(3, list.get(0));

        removed = list.removeAt(0);
        assertTrue(removed.isPresent());
        assertEquals(3, removed.get());
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());

        assertThrows(IndexOutOfBoundsException.class, () -> list.removeAt(0));
    }

    @Test
    void testClear() {
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());

        list.clear();
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());

        list.add(1);
        list.add(2);
        list.add(3);

        assertFalse(list.isEmpty());
        assertEquals(3, list.size());

        list.clear();
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    void testContains() {
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
        assertFalse(list.contains(1));

        list.add(1);
        assertTrue(list.contains(1));
        assertFalse(list.contains(2));

        list.add(2);
        assertTrue(list.contains(1));
        assertTrue(list.contains(2));
        assertFalse(list.contains(3));
    }

    @Test
    void testIterator() {
        list.add(1);
        list.add(2);
        list.add(3);

        assertTrue(list.iterator().hasNext());
        int index = 0;

        for (Integer i : list) {
            assertEquals(i, list.get(index));
            index++;
        }

        assertThrows(UnsupportedOperationException.class,
                     () -> list.iterator().remove());
    }
}
