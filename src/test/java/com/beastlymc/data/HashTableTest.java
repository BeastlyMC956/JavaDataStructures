package com.beastlymc.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HashTableTest {

    @Test
    void testPutAndGet() {
        HashTable<Integer> hashTable = new HashTable<>(5);
        hashTable.put(1);
        hashTable.put(2);
        hashTable.put(3);
        assertEquals(3, hashTable.getSize());
        assertEquals(11, hashTable.getCapacity());
        assertEquals(1, hashTable.getIndexForKey(1));
        assertEquals(2, hashTable.getIndexForKey(2));
        assertEquals(3, hashTable.getIndexForKey(3));
        assertEquals(-1, hashTable.getIndexForKey(4));
    }

    @Test
    void testPutArray() {
        HashTable<String> hashTable = new HashTable<>(5);
        String[] arrayValues = {"one", "two", "three"};
        hashTable.putArray(arrayValues);
        assertEquals(3, hashTable.getSize());
        assertEquals(11, hashTable.getCapacity());
        assertEquals(6, hashTable.getIndexForKey("one"));
        assertEquals(7, hashTable.getIndexForKey("two"));
        assertEquals(4, hashTable.getIndexForKey("three"));
        assertEquals(-1, hashTable.getIndexForKey("four"));
    }

    @Test
    void testResize() {
        HashTable<Character> hashTable = new HashTable<>(2);
        hashTable.put('A');
        hashTable.put('B');
        hashTable.put('C');
        assertEquals(3, hashTable.getSize());
        assertEquals(5, hashTable.getCapacity());
        assertEquals(0, hashTable.getIndexForKey('A'));
        assertEquals(1, hashTable.getIndexForKey('B'));
        assertEquals(2, hashTable.getIndexForKey('C'));
        assertEquals(-1, hashTable.getIndexForKey('D'));
    }
}
