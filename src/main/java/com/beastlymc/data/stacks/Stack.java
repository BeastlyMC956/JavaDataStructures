package com.beastlymc.data.stacks;

import com.beastlymc.data.arrays.Array;
import com.beastlymc.data.common.Pushable;

import java.util.Iterator;
import java.util.Optional;

/**
 * The Stack class represents a Last-In-First-Out (LIFO) stack data structure
 * that stores elements of type E.
 *
 * <p>This implementation is based on an underlying array and provides basic
 * stack operations such as push, pop, and peek, as well as other common
 * operations like size, clearing, and checking if the stack contains a specific
 * element.
 *
 * @param <E> the type of elements stored in the Stack
 */
public class Stack<E> implements Pushable<E> {
    private static final int DEFAULT_CAPACITY = 16;
    private int top;
    private final Array<E> data;


    /**
     * Constructs a new Stack with the specified capacity.
     *
     * @param capacity the maximum number of elements the Stack can hold
     */
    public Stack(final int capacity) {
        top = -1;
        data = new Array<>(capacity);
    }

    /**
     * Constructs a new Stack with the default capacity of 16.
     */
    public Stack() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Checks if the Stack is full.
     *
     * @return true if the Stack is full, false otherwise
     */
    public boolean isFull() {
        return top == data.length() - 1;
    }

    /**
     * Adds the specified element to the top of the Stack.
     *
     * @param value the element to add to the Stack
     *
     * @throws IllegalStateException if the Stack is full
     */
    @Override
    public void push(final E value) {
        if (isFull()) {
            throw new IllegalStateException("Stack is full");
        }

        top++;
        for (int i = top; i >= 1; i--) {
            data.insert(i, data.get(i - 1));
        }
        data.insert(0, value);

    }

    /**
     * Removes and returns the element at the top of the Stack.
     *
     * @return an {@link Optional} containing the element at the top of the
     * Stack, or {@link Optional#empty()} if the Stack is empty
     */
    @Override
    public Optional<E> pop() {
        if (isEmpty()) {
            return Optional.empty();
        }
        E element = data.get(top);
        data.remove(element);
        top--;
        return Optional.of(element);
    }

    /**
     * Returns the element at the top of the Stack without removing it.
     *
     * @return an {@link Optional} containing the element at the top of the
     * Stack, or {@link Optional#empty()} if the Stack is empty
     */
    @Override
    public Optional<E> peek() {
        if (isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(data.get(0));
    }

    /**
     * @return the number of elements in the Stack
     */
    @Override
    public int size() {
        return data.size();
    }

    /**
     * Removes all elements from the Stack.
     */
    @Override
    public void clear() {
        data.clear();
    }

    /**
     * Checks if the Stack contains the specified element.
     *
     * @param element the element to search for
     *
     * @return true if the Stack contains the element, false otherwise
     */
    @Override
    public boolean contains(final E element) {
        return data.contains(element);
    }

    /**
     * Returns an iterator over the elements in the Stack, from the top to the
     * bottom.
     *
     * @return an iterator over the elements in the Stack
     */
    @Override
    public Iterator<E> iterator() {
        return data.iterator();
    }

    /**
     * @return a string representation of the Stack
     */
    @Override
    public String toString() {
        return "Stack{" + "list=" + data + '}';
    }
}
