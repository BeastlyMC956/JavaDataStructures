package com.beastlymc.data.heaps;

import com.beastlymc.data.arrays.Array;

/**
 * Heap class represents an abstract heap data structure where elements are
 * sorted in a particular order.
 * <p>
 * The class provides abstract methods to insert and delete elements from the
 * heap. It also provides utility methods to access and manipulate the elements
 * in the heap.
 *
 * @param <T> The type of elements stored in the heap. The elements must be
 *            comparable with each other.
 *
 * @see Comparable
 */
public abstract class Heap<T extends Comparable<T>> {

    /**
     * The representation of the heap
     */
    protected final Array<T> heapArray;

    /**
     * The amount of elements in the heap
     */
    protected int size;

    /**
     * Constructs a new heap with the specified maximum size.
     *
     * @param maxSize The maximum size of the heap.
     */
    protected Heap(final int maxSize) {
        heapArray = new Array<>(maxSize);
        size = 0;
    }

    /**
     * Inserts the specified element into the heap.
     *
     * @param element The element to be inserted into the heap.
     */
    public abstract void insert(final T element);

    /**
     * Deletes the element at the top of the heap and returns it.
     *
     * @return The element at the top of the heap.
     */
    public abstract T delete();

    /**
     * Returns the index of the parent of the element at the specified index.
     *
     * @param index The index of the element.
     *
     * @return The index of the parent of the element.
     */
    public int getParentIndex(final int index) {
        return (index - 1) / 2;
    }

    /**
     * Returns the index of the left child of the element at the specified
     * index.
     *
     * @param index The index of the element.
     *
     * @return The index of the left child of the element.
     */
    public int getLeftChildIndex(final int index) {
        return (2 * index) + 1;
    }


    /**
     * Returns the index of the right child of the element at the specified
     * index.
     *
     * @param index The index of the element.
     *
     * @return The index of the right child of the element.
     */
    public int getRightChildIndex(final int index) {
        return (2 * index) + 2;
    }


    /**
     * Returns the size of the {@link Heap}
     *
     * @return the size of the {@link Heap}
     */
    public int size() {
        return size;
    }

    /**
     * Checks if the element at the specified index has a parent.
     *
     * @param index The index of the element.
     *
     * @return True if the element has a parent, false otherwise.
     */
    public boolean hasParent(final int index) {
        return getParentIndex(index) >= 0;
    }

    /**
     * Checks if the element at the specified index has a left child.
     *
     * @param index The index of the element.
     *
     * @return True if the element has a left child, false otherwise.
     */
    public boolean hasLeftChild(final int index) {
        return getLeftChildIndex(index) < size;
    }

    /**
     * Checks if the element at the specified index has a right child.
     *
     * @param index The index of the element.
     *
     * @return True if the element has a right child, false otherwise.
     */
    public boolean hasRightChild(final int index) {
        return getRightChildIndex(index) < size;
    }

    /**
     * Returns the parent of the element at the specified index.
     *
     * @param index The index of the element.
     *
     * @return The parent of the element.
     */
    public T getParent(final int index) {
        return heapArray.get(getParentIndex(index));
    }

    /**
     * Returns the left child of the element at the specified index.
     *
     * @param index The index of the element
     *
     * @return The left child of the element.
     */
    public T getLeftChild(final int index) {
        return heapArray.get(getLeftChildIndex(index));
    }

    /**
     * Returns the right child of the element at the specified index.
     *
     * @param index The index of the element.
     *
     * @return The right child of the element.
     */
    public T getRightChild(final int index) {
        return heapArray.get(getRightChildIndex(index));
    }

    /**
     * Swaps the elements at the specified indices in the heap.
     *
     * @param index1 The index of the first element.
     * @param index2 The index of the second element.
     */
    protected void swap(final int index1, final int index2) {
        T temp = heapArray.get(index1);
        heapArray.insert(index1, heapArray.get(index2));
        heapArray.insert(index2, temp);
    }

    /**
     * Returns a string representation of the heap in the form of a tree.
     *
     * @return A string representation of the heap.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (size > 0) {
            buildHeapTree(0, "", true, sb);
        }
        return sb.toString();
    }

    private void buildHeapTree(final int index, final String prefix, final boolean isTail, final StringBuilder sb) {
        sb.append(prefix).append(isTail
                                 ? "└─ "
                                 : "├─ ").append(heapArray.get(index))
                .append("\n");
        if (hasLeftChild(index)) {
            buildHeapTree(getLeftChildIndex(index), prefix + (isTail
                                                              ? "    "
                                                              : "│   "),
                          !hasRightChild(index), sb);
        }
        if (hasRightChild(index)) {
            buildHeapTree(getRightChildIndex(index), prefix + (isTail
                                                               ? "    "
                                                               : "│   "), true,
                          sb);
        }
    }
}
