package com.beastlymc.data.queues;

import com.beastlymc.data.common.Pushable;
import com.beastlymc.data.lists.LinkedList;

import java.util.Iterator;
import java.util.Optional;

/**
 * The Queue class represents a First-In-First-Out (FIFO) queue data structure
 * that stores elements of type E.
 *
 * <p>This class implements the Pushable interface and provides methods to add,
 * remove, and examine the elements in the queue.
 *
 * @param <E> the type of elements stored in the Queue.
 */
public class Queue<E> implements Pushable<E> {
    private final LinkedList<E> list;

    /**
     * Constructs a new Queue
     */
    public Queue() {
        list = new LinkedList<>();
    }

    /**
     * Adds the specified element to the back of the Queue.
     * <p>
     * This method is also commonly referred to as 'enqueue'.
     *
     * @param element the element to add to the Queue
     */
    @Override
    public void push(final E element) {
        list.add(element);
    }

    /**
     * Removes and returns the element at the front of the Queue.
     *
     * @return an {@link Optional} containing the element at the front of the
     * Queue, or {@link Optional#empty()} if the Queue is empty
     */
    @Override
    public Optional<E> pop() {
        if (list.isEmpty()) {
            return Optional.empty();
        }
        E ele = list.get(0);
        list.removeAt(0);
        return Optional.of(ele);
    }

    /**
     * Returns the element at the front of the Queue without removing it.
     *
     * @return an {@link Optional} containing the element at the front of the
     * Queue, or an {@link Optional#empty()} if the Queue is empty
     */
    @Override
    public Optional<E> peek() {
        if (list.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(list.get(0));
    }

    /**
     * Removes all the elements from the Queue.
     */
    public void clear() {
        list.clear();
    }

    /**
     * Returns true if the Queue contains the specified element.
     *
     * @param element the element to check for in the Queue
     *
     * @return true if the Queue contains the specified element, false otherwise
     */
    @Override
    public boolean contains(final E element) {
        return list.contains(element);
    }


    /**
     * @return the number of elements in the Queue
     */
    public int size() {
        return list.size();
    }

    /**
     * Returns an iterator over the elements in the Queue, from the top to the
     * bottom.
     *
     * @return an iterator over the elements in the Queue
     */
    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }

    /**
     * @return a string representation of the Queue
     */
    @Override
    public String toString() {
        return "Queue{" + "list=" + list + '}';
    }
}
