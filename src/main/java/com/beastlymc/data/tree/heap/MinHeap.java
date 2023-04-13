package com.beastlymc.data.tree.heap;

/**
 * MinHeap class represents a min heap data structure where the minimum element is always at the top.
 * <p>
 * The class extends the abstract Heap class and provides implementations for its abstract methods.
 *
 * @param <T> The type of elements stored in the heap. The elements must be comparable with each other.
 *
 * @see Comparable
 * @see com.beastlymc.data.tree.heap.Heap
 */
public class MinHeap<T extends Comparable<T>> extends Heap<T> {

    /**
     * Constructs a new min heap with the specified maximum size.
     *
     * @param maxSize The maximum size of the heap.
     */
    public MinHeap(final int maxSize) {
        super(maxSize);
    }

    /**
     * Inserts the specified element into the heap and maintains the min-heap property.
     *
     * @param element The element to be inserted into the heap.
     *
     * @throws IllegalStateException if the heap is full.
     */
    @Override
    public void insert(final T element) {
        if (size == heapArray.getCapacity()) {
            throw new IllegalStateException("Heap is full");
        }
        heapArray.set(size, element);
        heapifyUp(size);
        size++;
    }

    /**
     * Deletes the minimum element from the heap and maintains the min heap property.
     *
     * @return The minimum element in the min-heap.
     *
     * @throws RuntimeException if the heap is empty.
     */
    @Override
    public T delete() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }

        T minElement = heapArray.get(0);
        heapArray.set(0, heapArray.get(size - 1));
        size--;
        heapifyDown(0);
        return minElement;
    }

    /**
     * A helper method to move the element at the specified index up the heap
     * until the min-heap property is satisfied
     *
     * @param index The index of the element to be moved.
     */
    private void heapifyUp(int index) {
        while (hasParent(index) && getParent(index).compareTo(heapArray.get(index)) > 0) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    /**
     * A helper method to move the element at the root of the heap down until the min-heap property is satisfied
     */
    private void heapifyDown(int index) {
        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && getRightChild(index).compareTo(getLeftChild(index)) < 0) {
                smallerChildIndex = getRightChildIndex(index);
            }
            if (heapArray.get(index).compareTo(heapArray.get(smallerChildIndex)) < 0) {
                break;
            } else {
                swap(index, smallerChildIndex);
            }
            index = smallerChildIndex;
        }
    }
}
