package com.beastlymc.data.tree.heap;

import com.beastlymc.data.array.Array;

/**
 * Heap class represents an abstract heap data structure where elements are sorted in a particular order.
 * <p>
 * The class provides abstract methods to insert and delete elements from the heap. It also provides utility
 * methods to access and manipulate the elements in the heap.
 *
 * @param <T> The type of elements stored in the heap. The elements must be comparable with each other.
 *
 * @see Comparable
 */
public abstract class Heap<T extends Comparable<T>> {
    protected Array<T> heapArray;
    protected int size;

    /**
     * Constructs a new heap with the specified maximum size.
     *
     * @param maxSize The maximum size of the heap.
     */
    protected Heap(int maxSize) {
        heapArray = new Array<>(maxSize);
        size = 0;
    }

    /**
     * Inserts the specified element into the heap.
     *
     * @param element The element to be inserted into the heap.
     */
    public abstract void insert(T element);

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
    protected int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    /**
     * Returns the index of the left child of the element at the specified index.
     *
     * @param index The index of the element.
     *
     * @return The index of the left child of the element.
     */
    protected int getLeftChildIndex(int index) {
        return (2 * index) + 1;
    }

    /**
     * Returns the index of the right child of the element at the specified index.
     *
     * @param index The index of the element.
     *
     * @return The index of the right child of the element.
     */
    protected int getRightChildIndex(int index) {
        return (2 * index) + 2;
    }

    /**
     * Checks if the element at the specified index has a parent.
     *
     * @param index The index of the element.
     *
     * @return True if the element has a parent, false otherwise.
     */
    protected boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    /**
     * Checks if the element at the specified index has a left child.
     *
     * @param index The index of the element.
     *
     * @return True if the element has a left child, false otherwise.
     */
    protected boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    /**
     * Checks if the element at the specified index has a right child.
     *
     * @param index The index of the element.
     *
     * @return True if the element has a right child, false otherwise.
     */
    protected boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    /**
     * Returns the parent of the element at the specified index.
     *
     * @param index The index of the element.
     *
     * @return The parent of the element.
     */
    protected T getParent(int index) {
        return heapArray.get(getParentIndex(index));
    }

    /**
     * Returns the left child of the element at the specified index.
     *
     * @param index The index of the element
     *
     * @return The left child of the element.
     */
    protected T getLeftChild(int index) {
        return heapArray.get(getLeftChildIndex(index));
    }

    /**
     * Returns the right child of the element at the specified index.
     *
     * @param index The index of the element.
     *
     * @return The right child of the element.
     */
    protected T getRightChild(int index) {
        return heapArray.get(getRightChildIndex(index));
    }

    /**
     * Swaps the elements at the specified indices in the heap.
     *
     * @param index1 The index of the first element.
     * @param index2 The index of the second element.
     */
    protected void swap(int index1, int index2) {
        T temp = heapArray.get(index1);
        heapArray.set(index1, heapArray.get(index2));
        heapArray.set(index2, temp);
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

    private void buildHeapTree(int index, String prefix, boolean isTail, StringBuilder sb) {
        sb.append(prefix).append(isTail
                                 ? "└─ "
                                 : "├─ ").append(heapArray.get(index)).append("\n");
        if (hasLeftChild(index)) {
            buildHeapTree(getLeftChildIndex(index), prefix + (isTail
                                                              ? "    "
                                                              : "│   "), !hasRightChild(index), sb);
        }
        if (hasRightChild(index)) {
            buildHeapTree(getRightChildIndex(index), prefix + (isTail
                                                               ? "    "
                                                               : "│   "), true, sb);
        }
    }
}