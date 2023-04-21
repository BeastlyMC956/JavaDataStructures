package com.beastlymc.data.common;

import java.util.Iterator;

/**
 * The Collection interface represents a group of elements.
 *
 * @param <E> the type of elements in this collection
 */
public interface Collection<E> extends Iterable<E> {

    /**
     * Returns the number of elements in this collection
     *
     * @return the number of elements in this collection
     */
    int size();

    /**
     * Removes all elements from this collection.
     */
    void clear();

    /**
     * Checks if this collection contains no elements
     *
     * @return true if this collection contains no elements, false otherwise
     */
    default boolean isEmpty() {
        return this.size() == 0;
    }

    /**
     * Returns true if this collection contains the specified element.
     *
     * @param element the element to check for
     *
     * @return true if this collection contains the specified element, false
     * otherwise
     */
    boolean contains(final E element);

    /**
     * @return an iterator over the elements in this collection
     */
    @Override
    Iterator<E> iterator();
}
