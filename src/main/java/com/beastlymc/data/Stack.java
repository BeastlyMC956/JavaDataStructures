package com.beastlymc.data;

/**
 * The Stack class represents a Last-In-First-Out (LIFO) stack data structure that stores elements of type E.
 *
 * @param <E> the type of elements stored in the Stack.
 */
public class Stack<E> {
    private int top;
    private final Array<E> data;

    /**
     * Constructs a new Stack with the specified capacity.
     *
     * @param capacity the maximum number of elements the Stack can hold
     */
    public Stack(int capacity) {
        top = -1;
        data = new Array<>(capacity);
    }

    /**
     * @return true if the Stack is empty, false otherwise
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * @return true if the Stack is full, false otherwise
     */
    public boolean isFull() {
        return top == data.getCapacity() - 1;
    }

    /**
     * Adds the specified element to the top of the Stack.
     *
     * @param value the element to add to the Stack
     *
     * @throws IllegalStateException if the Stack is full
     */
    public void push(E value) {
        if (isFull()) {
            throw new IllegalStateException("Stack is full");
        }
        top++;
        data.addLast(value);
    }

    /**
     * Removes and returns the element at the top of the Stack.
     *
     * @return the element at the top of the Stack
     *
     * @throws IllegalStateException if the Stack is empty
     */
    public E pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        E element = data.get(top);
        top--;
        return element;
    }

    /**
     * Returns the element at the top of the Stack without removing it.
     *
     * @return the element at the top of the Stack
     *
     * @throws IllegalStateException if the Stack is empty
     */
    public E peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return data.get(top);
    }
}
