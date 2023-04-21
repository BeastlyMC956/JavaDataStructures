package com.beastlymc.data.common;

/**
 * An object that maps keys to values. A map cannot contain duplicate keys; each
 * key can map to at most one value.
 *
 * @param <K> the type of keys maintained by this map
 * @param <V> the type of mapped values
 */
public interface Map<K, V> {
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
    V put(final K key, final V value);

    /**
     * Returns the value to which the specified key is mapped, or null if this
     * collection contains no mapping for the key.
     *
     * @param key the key whose associated value is to be returned
     *
     * @return the value to which the specified key is mapped, or null if this
     * collection contains no mapping for the key
     */
    V get(final K key);

    /**
     * Removes the mapping for the specified key from this collection if
     * present.
     *
     * @param key the key whose mapping is to be removed from the collection
     *
     * @return the previous value associated with the key, or null if there was
     * no mapping for the key
     */
    V remove(final K key);

    /**
     * Returns true if this collection contains a mapping for the specified
     * key.
     *
     * @param key the key whose presence in this collection is to be tested
     *
     * @return true if this collection contains a mapping for the specified key,
     * false otherwise
     */
    boolean containsKey(final K key);

    /**
     * Returns the number of key-value mappings in this collection
     *
     * @return the number of key-value mappings in this collection
     */
    int size();

    /**
     * Removes all mappings from this collection.
     */
    void clear();

    /**
     * Checks if this collection contains no key-value mappings
     *
     * @return true if this collection contains no key-value mappings, false
     * otherwise
     */
    default boolean isEmpty() {
        return this.size() == 0;
    }
}
