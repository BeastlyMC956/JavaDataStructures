package com.beastlymc.data.heaps;

/**
 * MaxHeap class represents a max heap data structure where the maximum element
 * is always at the top.
 * <p>
 * The class extends the abstract Heap class and provides implementations for
 * its abstract methods.
 *
 * @param <T> The type of elements stored in the heap. The elements must be
 *            comparable with each other.
 *
 * @see Comparable
 * @see Heap
 */
public class MaxHeap<T extends Comparable<T>> extends Heap<T> {

    /**
     * Constructs a new max heap with the specified maximum size.
     *
     * @param maxSize The maximum size of the heap.
     */
    public MaxHeap(final int maxSize) {
        super(maxSize);
    }

    /**
     * Inserts the specified element into the heap and maintains the max-heap
     * property.
     *
     * @param element The element to be inserted into the heap.
     *
     * @throws IllegalStateException if the heap is full.
     */
    @Override
    public void insert(final T element) {
        if (size == heapArray.length()) {
            throw new IllegalStateException("Heap is full");
        }
        heapArray.insert(size, element);
        heapifyUp(size);
        size++;
    }

    /**
     * Deletes the top element from the max heap and maintains the max-heap
     * property.
     *
     * @return The maximum element in the heap.
     *
     * @throws IllegalStateException if the heap is empty.
     */
    @Override
    public T delete() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        T deletedElement = heapArray.get(0);
        heapArray.insert(0, heapArray.get(size - 1));
        size--;
        heapifyDown();
        return deletedElement;
    }

    /**
     * A helper method to move the element at the specified index up the heap
     * until the max-heap property is satisfied
     *
     * @param index The index of the element to be moved.
     */
    private void heapifyUp(int index) {
        while (hasParent(index) &&
               getParent(index).compareTo(heapArray.get(index)) < 0) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    /**
     * A helper method to move the element at the root of the heap down until
     * the max-heap property is satisfied
     */
    private void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int largerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) &&
                getRightChild(index).compareTo(getLeftChild(index)) > 0) {
                largerChildIndex = getRightChildIndex(index);
            }
            if (heapArray.get(index)
                        .compareTo(heapArray.get(largerChildIndex)) > 0) {
                break;
            } else {
                swap(index, largerChildIndex);
            }
            index = largerChildIndex;
        }
    }
}
