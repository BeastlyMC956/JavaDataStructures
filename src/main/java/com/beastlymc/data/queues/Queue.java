package com.beastlymc.data.queues;

import com.beastlymc.data.lists.LinkedList;

/**
 * The Queue class represents a First-In-First-Out (FIFO) queue data structure
 * that stores elements of type E.
 *
 * @param <E> the type of elements stored in the Queue.
 */
public class Queue<E> {
    private final LinkedList<E> list;

    /**
     * Constructs a new Queue
     */
    public Queue() {
        list = new LinkedList<>();
    }

    /**
     * @return true if the Queue is empty, false otherwise
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Returns the element at the front of the Queue without removing it.
     *
     * @return the element at the front of the Queue, or null if the Queue is
     * empty
     */
    public E peek() {
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public void clear() {
        list.clear();
    }

    public int size() {
        return list.getSize();
    }


    /**
     * Adds the specified element to the back of the Queue.
     * <p>
     * Also, commonly referred to as `enqueue`
     *
     * @param element the element to add to the Queue
     */
    public void offer(final E element) {
        list.add(element);
    }

    /**
     * Removes and returns the element at the front of the Queue.
     *
     * @return the element at the front of the Queue, or null if the Queue is
     * empty
     */
    public E poll() {
        if (list.isEmpty()) {
            return null;
        }
        E ele = list.get(0);
        list.remove(0);
        return ele;
    }

    /**
     * @return a string representation of the Queue
     */
    @Override
    public String toString() {
        return "Queue{" + "list=" + list + '}';
    }
}
