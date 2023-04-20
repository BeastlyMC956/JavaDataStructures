package com.beastlymc.data.lists;

import com.beastlymc.data.common.Insertable;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * The LinkedList class represents a linked list data structure that stores
 * elements of type E.
 *
 * @param <E> the type of elements stored in the LinkedList.
 */
public class LinkedList<E> implements Insertable<E> {

    /**
     * The Node class represents a node in the LinkedList, storing an element of
     * type E and a reference to the next node.
     *
     * @param <E> the same type of elements that is stored in the LinkedList.
     */
    private static final class Node<E> {
        private E data;
        private Node<E> next;

        private Node(final E data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size;

    /**
     * Constructs an empty LinkedList.
     */
    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    /**
     * Adds the specified element to the end of the LinkedList.
     *
     * @param element the element to add to the LinkedList
     */
    @Override
    public void append(final E element) {
        Node<E> newNode = new Node<>(element);

        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    /**
     * Adds the specified element to the beginning of the LinkedList.
     *
     * @param element the element to add to the beginning of the LinkedList
     */
    public void addFirst(final E element) {
        Node<E> newNode = new Node<>(element);
        newNode.next = head;
        head = newNode;
        size++;
    }

    @Override
    public void insert(final int index, final E element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index);
        }
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.data = element;
    }

    @Override
    public Optional<E> remove(final E element) {
        Node<E> current = head;
        for (int i = 0; i < size - 1; i++) {
            if (current.data.equals(element)) {
                return removeAt(i);
            }
            current = current.next;
        }
        return Optional.empty();
    }

    @Override
    public Optional<E> removeAt(final int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index);
        }

        Optional<E> returnNode;
        if (index == 0) {
            returnNode = Optional.of(head.data);
            head = head.next;
        } else {
            Node<E> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            returnNode = Optional.of(current.next.data);
            current.next = current.next.next;
        }
        size--;
        return returnNode;
    }

    /**
     * Returns the element at the specified index in the LinkedList.
     *
     * @param index the index of the element to retrieve
     *
     * @return the element at the specified index in the LinkedList
     *
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public E get(final int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.data;
    }

    /**
     * Clears all elements from this linked list.
     */
    @Override
    public void clear() {
        if (size() == 0) {
            return;
        }

        for (int i = 0; i < size(); i++) {
            removeAt(i);
        }
    }

    /**
     * Returns true if the LinkedList contains the specified element, false
     * otherwise.
     *
     * @param element the element to search for in the LinkedList
     *
     * @return true if the LinkedList contains the specified element, false
     * otherwise
     */
    @Override
    public boolean contains(final E element) {
        Node<E> current = head;
        while (current != null) {
            if (current.data.equals(element)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator<>(head);
    }

    /**
     * @return a string representation of the LinkedList
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        Node<E> current = head;
        while (current != null) {
            builder.append(current.data);
            if (current.next != null) {
                builder.append(", ");
            }
            current = current.next;
        }
        builder.append("]");
        return builder.toString();
    }

    private static class LinkedListIterator<E> implements Iterator<E> {

        private Node<E> current;

        public LinkedListIterator(Node<E> head) {
            current = head;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E data = current.data;
            current = current.next;
            return data;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
