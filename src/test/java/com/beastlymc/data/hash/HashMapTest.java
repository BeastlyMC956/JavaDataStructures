package com.beastlymc.data.hash;

import com.beastlymc.data.common.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashMapTest {
    private Map<String, Integer> map;

    @BeforeEach
    void setUp() {
        assertNull(map);
        map = new HashMap<>();
        assertTrue(map.isEmpty());
        assertInstanceOf(Map.class, map);
    }

    @Test
    void testPutAndGet() {
        assertNull(map.put("one", 1));
        assertNull(map.put("two", 2));
        assertNull(map.put("three", 3));

        assertFalse(map.isEmpty());

        assertEquals(1, map.get("one"));
        assertEquals(2, map.get("two"));
        assertEquals(3, map.get("three"));
    }

    @Test
    void testPutWithCollision() {
        assertNull(map.put("one", 1));
        assertNull(map.put("neo", 2));
        assertEquals(1, map.get("one"));
        assertEquals(2, map.get("neo"));
    }

    @Test
    void testPutReplace() {
        assertNull(map.put("one", 1));
        assertEquals(1, map.put("one", 111));
        assertEquals(111, map.get("one"));
    }

    @Test
    void testRemove() {
        assertNull(map.put("one", 1));
        assertEquals(1, map.remove("one"));
        assertNull(map.get("one"));
    }

    @Test
    void testRemoveNonexistent() {
        assertTrue(map.isEmpty());
        assertNull(map.remove("one"));
    }

    @Test
    void testContainsKey() {
        assertFalse(map.containsKey("one"));
        assertNull(map.put("one", 1));
        assertTrue(map.containsKey("one"));
    }

    @Test
    void testSize() {
        assertEquals(0, map.size());
        assertNull(map.put("one", 1));
        assertEquals(1, map.size());
        assertNull(map.put("two", 2));
        assertEquals(2, map.size());
    }

    @Test
    void testClear() {
        assertNull(map.put("one", 1));
        assertEquals(1, map.size());
        map.clear();
        assertEquals(0, map.size());
        assertNull(map.get("one"));
    }
}
