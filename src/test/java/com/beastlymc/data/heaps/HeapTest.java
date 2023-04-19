package com.beastlymc.data.heaps;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeapTest {
    public Heap<Integer> heap;

    @Test
    void insert() {
        heap = new MaxHeap<>(10);
        assertEquals(0, heap.getSize());
        heap.insert(35);
        heap.insert(33);
        heap.insert(42);
        heap.insert(10);
        heap.insert(14);
        heap.insert(19);
        heap.insert(27);
        heap.insert(44);
        heap.insert(26);
        heap.insert(31);

        assertEquals(10, heap.getSize());

        assertTrue(heap.hasParent(0));
        assertTrue(heap.hasLeftChild(0));
        assertTrue(heap.hasLeftChild(1));
        assertTrue(heap.hasLeftChild(2));
        assertTrue(heap.hasLeftChild(3));
        assertTrue(heap.hasLeftChild(4));
        assertFalse(heap.hasLeftChild(5));

        assertTrue(heap.hasRightChild(0));
        assertTrue(heap.hasRightChild(1));
        assertTrue(heap.hasRightChild(2));
        assertTrue(heap.hasRightChild(3));
        assertFalse(heap.hasRightChild(4));

        assertEquals(44, heap.getParent(0));
        assertEquals(42, heap.getLeftChild(0));
        assertEquals(33, heap.getLeftChild(1));
        assertEquals(19, heap.getLeftChild(2));
        assertEquals(10, heap.getLeftChild(3));
        assertEquals(14, heap.getLeftChild(4));

        assertEquals(35, heap.getRightChild(0));
        assertEquals(31, heap.getRightChild(1));
        assertEquals(27, heap.getRightChild(2));
        assertEquals(26, heap.getRightChild(3));

        assertThrows(IllegalStateException.class, () -> heap.insert(20));
    }

    @Test
    void delete() {
        heap = new MinHeap<>(10);
        assertEquals(0, heap.getSize());
        assertThrows(IllegalStateException.class, () -> heap.delete());

        heap.insert(35);
        heap.insert(33);
        heap.insert(42);
        heap.insert(10);
        heap.insert(14);
        heap.insert(19);
        heap.insert(27);
        heap.insert(44);
        heap.insert(26);
        heap.insert(31);

        assertEquals(10, heap.delete());
        assertEquals(14, heap.getParent(0));

        heap = new MaxHeap<>(10);
        assertEquals(0, heap.getSize());
        assertThrows(IllegalStateException.class, () -> heap.delete());

        heap.insert(35);
        heap.insert(33);
        heap.insert(42);
        heap.insert(10);
        heap.insert(14);
        heap.insert(19);
        heap.insert(27);
        heap.insert(44);
        heap.insert(26);
        heap.insert(31);

        assertEquals(44, heap.delete());
        assertEquals(42, heap.getParent(0));
    }
}
