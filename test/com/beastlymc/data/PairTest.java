package com.beastlymc.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PairTest {

    @Test
    void testPairOperations() {
        Pair<Integer, Boolean> pair = new Pair<>(2, true);

        assertEquals(2, pair.getLeft());
        assertTrue(pair.getRight());

        pair.setLeft(5);
        pair.setRight(false);

        assertEquals(5, pair.getLeft());
        assertFalse(pair.getRight());

        Pair<Integer, Boolean> secondPair = new Pair<>(5, false);

        assertEquals(secondPair, pair);
        assertTrue(secondPair.equals(secondPair));
        assertFalse(secondPair.equals(null));

        assertEquals(secondPair.hashCode(), pair.hashCode());

        assertEquals("Pair(5, false)", pair.toString());

        assertEquals(2, pair.toArray().length);

        Object[] objArr = new Object[2];
        objArr[0] = 5;
        objArr[1] = Boolean.FALSE;

        assertArrayEquals(objArr, pair.toArray());

    }

}