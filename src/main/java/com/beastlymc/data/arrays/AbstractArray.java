package com.beastlymc.data.arrays;

public abstract class AbstractArray<E> {
    private final int capacity;

    protected AbstractArray(final int capacity) {
        this.capacity = capacity;
    }

    /**
     * @return The current capacity of the array.
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Checks if the array is empty.
     *
     * @return True if the array is empty, false otherwise.
     */
    public boolean isEmpty() {
        return getSize() == 0;
    }

    /**
     * Gets the element at the specified index.
     *
     * @param index The index of the element to get.
     *
     * @return The element at the specified index.
     *
     * @throws IndexOutOfBoundsException If the index is out of bounds.
     */
    public E get(final int index) {
        if (index < 0 || index > getCapacity()) {
            throw new IndexOutOfBoundsException(index);
        }
        return toArray()[index];
    }

    /**
     * Checks if the array contains the specified element.
     *
     * @param element The element to check for.
     *
     * @return True if the array contains the element, false otherwise.
     */
    public boolean contains(final E element) {
        for (int i = 0; i < getSize(); i++) {
            if (toArray()[i].equals(element)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Returns the index of the first occurrence of the specified element in
     * this array, or -1 if the array does not contain the element.
     *
     * @param element The element to search for.
     *
     * @return The index of the first occurrence of the element, or -1 if the
     * element is not found.
     */
    public int indexOf(final E element) {
        for (int i = 0; i < getSize(); i++) {
            if (toArray()[i].equals(element)) {
                return i;
            }
        }

        return -1;
    }

    public abstract E[] toArray();

    /**
     * Appends the specified element in this array.
     *
     * @param element The element to be appended.
     */
    public abstract void add(final E element);

    /**
     * Sets the value of the element at the specified index.
     *
     * @param index   The index of the element to set.
     * @param element The new element to be inserted.
     *
     * @throws IndexOutOfBoundsException If the index is out of bounds.
     */
    public abstract E set(final int index, final E element);

    /**
     * Removes the first occurrence of the specified element from this array.
     *
     * @param element The element to remove.
     */
    public abstract E removeElement(final E element);

    /**
     * Removes the element at the specified index from this array.
     *
     * @param index The index of the element to be removed.
     *
     * @return The element that was removed from the array.
     *
     * @throws IndexOutOfBoundsException If the index is out of bounds.
     */
    public abstract E remove(final int index);

    /**
     * Returns the number of elements currently stored in the array.
     *
     * @return The number of elements in the array.
     */
    public abstract int getSize();

    /**
     * Clears all elements from this array.
     */
    public abstract void clear();

    /**
     * @return A string representation of this array.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Array size = %d, capacity = %d%n", getSize(),
                                toArray().length));
        sb.append("[");

        for (int i = 0; i < getSize(); i++) {
            sb.append(toArray()[i]);

            if (i != getSize() - 1) {
                sb.append(", ");
            }
        }

        sb.append("]");

        return sb.toString();
    }
}
