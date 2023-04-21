package com.beastlymc.data.hash;

import com.beastlymc.data.arrays.Array;
import com.beastlymc.data.common.Map;
import com.beastlymc.data.lists.LinkedList;

/**
 * A hash map implementation of the Map interface using a dynamic array of
 * linked lists to handle collisions.
 *
 * @param <K> the type of keys in the map
 * @param <V> the type of values in the map
 */
public class HashMap<K, V> implements Map<K, V> {

    /**
     * The default initial capacity of the hash map.
     */
    private static final int DEFAULT_CAPACITY = 16;

    /**
     * The load factor threshold at which the hash map should be resized.
     */
    private static final float LOAD_FACTOR = 0.75f;

    /**
     * The array used to store the hash map.
     */
    private Array<LinkedList<Entry<K, V>>> table;

    /**
     * The amount of elements in the table
     */
    private int size;

    /**
     * Constructs a HashMap with a given capacity
     *
     * @param initialCapacity the initial capacity of the hash map
     */
    public HashMap(int initialCapacity) {
        table = new Array<>(initialCapacity);
        size = 0;
    }

    /**
     * Constructs a HashMap with the default capacity of 16
     */
    public HashMap() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Associates the specified value with the specified key in this
     * collection.
     *
     * @param key   the key with which the specified value is to be associated
     * @param value the value to be associated with the specified key
     *
     * @return the previous value associated with the key, or null if there was
     * no mapping for the key
     */
    @Override
    public V put(final K key, final V value) {
        int index = hash(key) % table.length();

        if (table.get(index) == null) {
            table.insert(index, new LinkedList<>());
        }

        for (Entry<K, V> entry : table.get(index)) {
            if (entry.key.equals(key)) {
                V oldValue = entry.value;
                entry.value = value;
                return oldValue;
            }
        }

        table.get(index).add(new Entry<>(key, value));
        size++;

        if (size > table.size() * LOAD_FACTOR) {
            resize();
        }

        return null;
    }

    @Override
    public V get(final K key) {
        int index = hash(key) % table.length();

        if (table.get(index) == null) {
            return null;
        }

        for (Entry<K, V> entry : table.get(index)) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }

        return null;
    }

    @Override
    public V remove(final K key) {
        int index = hash(key) % table.length();

        if (table.get(index) == null) {
            return null;
        }

        for (Entry<K, V> entry : table.get(index)) {
            if (entry.key.equals(key)) {
                table.get(index).remove(entry);
                size--;
                return entry.value;
            }
        }

        return null;
    }

    @Override
    public boolean containsKey(final K key) {
        int index = hash(key) % table.length();

        if (table.get(index) == null) {
            return false;
        }

        for (Entry<K, V> entry : table.get(index)) {
            if (entry.key.equals(key)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Returns the number of key-value mappings in this HashMap
     *
     * @return the number of key-value mappings in this HashMap
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Removes all mappings from this HashMap.
     */
    @Override
    public void clear() {
        int length = table.size();
        table = new Array<>(length);
        size = 0;
    }

    /**
     * Resizes the hash map by doubling the capacity and rehashing all key-value
     * pairs.
     */
    private void resize() {
        int newCapacity = table.length() * 2;
        LinkedList<Entry<K, V>>[] newTable = new LinkedList[newCapacity];

        for (LinkedList<Entry<K, V>> bucket : table) {
            if (bucket != null) {
                for (Entry<K, V> entry : bucket) {
                    int index = hash(entry.key) % newCapacity;

                    if (newTable[index] == null) {
                        newTable[index] = new LinkedList<>();
                    }

                    newTable[index].add(entry);
                }
            }
        }
    }

    /**
     * Computes the hash code of the specified key.
     *
     * @param key the key for which to compute the hash code
     *
     * @return the positive hash code of the specified key
     */
    private int hash(K key) {
        return (key.hashCode() & 0x7FFFFFFF);
    }

    /**
     * An entry in the hash map, consisting of a key and a value.
     *
     * @param <K> the type of the key
     * @param <V> the type of the value
     */
    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * @return a string representation of this map
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");

        boolean isFirstEntry = true;
        for (int i = 0; i < table.size(); i++) {
            if (table.get(i) != null) {
                for (Entry<K, V> entry : table.get(i)) {
                    if (isFirstEntry) {
                        isFirstEntry = false;
                    } else {
                        sb.append(", ");
                    }
                    sb.append(entry.key.toString());
                    sb.append("=");
                    sb.append(entry.value.toString());
                }
            }
        }

        sb.append("}");
        return sb.toString();
    }
}
