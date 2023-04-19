package com.beastlymc.data.lists;

/**
 * The LinkedList class represents a linked list data structure that stores
 * elements of type E.
 *
 * @param <E> the type of elements stored in the LinkedList.
 */
public class LinkedList<E> {

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

    /**
     * @return the size of the LinkedList
     */
    public int getSize() {
        return size;
    }

    /**
     * @return true if the LinkedList is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Adds the specified element to the end of the LinkedList.
     *
     * @param element the element to add to the LinkedList
     */
    public void add(final E element) {
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

    /**
     * Sets the element at the specified index to the specified element.
     *
     * @param index   the index of the element to set
     * @param element the element to set at the specified index
     *
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public void set(final int index, final E element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index);
        }
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.data = element;
    }

    /**
     * Removes the element at the specified index from the LinkedList.
     *
     * @param index the index of the element to remove
     *
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public void remove(final int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index);
        }
        if (index == 0) {
            head = head.next;
        } else {
            Node<E> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
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
    public void clear() {
        if (getSize() == 0) {
            return;
        }

        for (int i = 0; i < getSize(); i++) {
            remove(i);
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
}
