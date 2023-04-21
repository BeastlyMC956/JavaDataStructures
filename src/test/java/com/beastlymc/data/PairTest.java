package com.beastlymc.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PairTest {

    @Test
    void testPairConstructor() {
        Pair<String, Integer> pair = new Pair<>("foo", 42);
        assertEquals("foo", pair.getLeft());
        assertEquals(42, pair.getRight());
    }

    @Test
    void testSetLeft() {
        Pair<String, Integer> pair = new Pair<>("foo", 42);
        pair.setLeft("bar");
        assertEquals("bar", pair.getLeft());
    }

    @Test
    void testSetRight() {
        Pair<String, Integer> pair = new Pair<>("foo", 42);
        pair.setRight(99);
        assertEquals(99, pair.getRight());
    }

    @Test
    void testToArray() {
        Pair<String, Integer> pair = new Pair<>("foo", 42);
        Object[] expected = {"foo", 42};
        assertArrayEquals(expected, pair.toArray());
    }

    @Test
    void testEquals() {
        Pair<String, Integer> pair1 = new Pair<>("foo", 42);
        Pair<String, Integer> pair2 = new Pair<>("foo", 42);
        Pair<String, Integer> pair3 = new Pair<>("bar", 99);
        assertEquals(pair1, pair2);
        assertNotEquals(pair1, pair3);
    }

    @Test
    void testHashCode() {
        Pair<String, Integer> pair1 = new Pair<>("foo", 42);
        Pair<String, Integer> pair2 = new Pair<>("foo", 42);
        Pair<String, Integer> pair3 = new Pair<>("bar", 99);
        assertEquals(pair1.hashCode(), pair2.hashCode());
        assertNotEquals(pair1.hashCode(), pair3.hashCode());
    }

    @Test
    void testToString() {
        Pair<String, Integer> pair = new Pair<>("foo", 42);
        assertEquals("Pair(foo, 42)", pair.toString());
    }

}
