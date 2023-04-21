package com.beastlymc.data.common;

import java.util.Optional;

/**
 * The Insertable interface represents a collection that supports inserting and
 * deleting elements at specific positions.
 *
 * @param <E> the type of elements in this collection
 */
public interface Insertable<E> extends Collection<E> {

    /**
     * Inserts the specified element at the specified position in the
     * collection.
     *
     * @param index   the index at which to insert the element
     * @param element the element to insert
     *
     * @throws IndexOutOfBoundsException if the provided index can't be reached
     */
    void insert(final int index, final E element) throws IndexOutOfBoundsException;

    /**
     * Appends the specified element to the end of this collection.
     *
     * @param element the element to append
     */
    default void append(final E element) {
        insert(size(), element);
    }

    /**
     * Removes the first occurrence of the specified element from this
     * collection, if it is present.
     *
     * @param element the element to remove
     *
     * @return an Optional containing the removed element, or an empty Optional
     * if the element was not found
     */
    Optional<E> remove(final E element);

    /**
     * Removes the element at the specified position in this collection.
     *
     * @param index the index of the element to remove
     *
     * @return an Optional containing the removed element, or an empty Optional
     * if the index is out of range
     *
     * @throws IndexOutOfBoundsException if the provided index can't be reached
     */
    Optional<E> removeAt(final int index) throws IndexOutOfBoundsException;
}
