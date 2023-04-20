package com.beastlymc.data.hash;

import com.beastlymc.data.arrays.Array;
import com.beastlymc.data.common.Map;
import com.beastlymc.data.lists.LinkedList;


public class HashMap<K, V> implements Map<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;
    private Array<LinkedList<Entry<K, V>>> table;
    private int size;

    public HashMap(int initialCapacity) {
        table = new Array<>(initialCapacity);
        size = 0;
    }

    public HashMap() {
        this(DEFAULT_CAPACITY);
    }

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

        table.get(index).append(new Entry<>(key, value));
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
        int index = hash(key);

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

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        int length = table.size();
        table = new Array<>(length);
        size = 0;
    }

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

                    newTable[index].append(entry);
                }
            }
        }
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7FFFFFFF);
    }

    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

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
