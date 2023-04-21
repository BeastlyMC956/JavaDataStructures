package com.beastlymc.data.common;

import java.util.Optional;

/**
 * The Pushable interface represents a collection that supports pushing and
 * popping elements.
 *
 * @param <E> the type of elements in this collection
 */
public interface Pushable<E> extends Collection<E> {

    /**
     * Adds the specified element onto the top of this collection.
     *
     * @param element the element to push onto the collection
     */
    void push(final E element);

    /**
     * Removes and returns the top element from this collection.
     *
     * @return an {@link Optional} containing the removed element, or
     * {@link Optional#empty()} if the collection is empty
     */
    Optional<E> pop();

    /**
     * Retrieves, but does not remove, the top element of this collection.
     *
     * @return an {@link Optional} containing the top element, or
     * {@link Optional#empty()} if the collection is empty
     */
    Optional<E> peek();

    /**
     * {@inheritDoc}
     *
     * <p>This implementation delegates to the default implementation in
     * {@link Collection}.</p>
     */
    @Override
    default boolean isEmpty() {
        return Collection.super.isEmpty();
    }
}
