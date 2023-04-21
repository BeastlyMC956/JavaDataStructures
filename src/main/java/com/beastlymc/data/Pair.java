package com.beastlymc.data;

import java.util.Objects;

/**
 * A generic class that represents a pair of two values, one of type K and the
 * other of type V.
 *
 * @param <K> the type of the left-side value in the pair
 * @param <V> the type of the right-side value in the pair
 */
public class Pair<K, V> {
    private K leftSide;
    private V rightSide;

    /**
     * Constructs a new Pair with the given left-side and right-side values.
     *
     * @param leftSide  the value to use as the left-side value in the pair
     * @param rightSide the value to use as the right-side value in the pair
     */
    public Pair(final K leftSide, final V rightSide) {
        this.leftSide = leftSide;
        this.rightSide = rightSide;
    }

    /**
     * Constructor for an empty Pair.
     */
    public Pair() {
        this(null, null);
    }

    /**
     * Sets the value of the left-side value in the pair.
     *
     * @param leftSide the value to use as the left-side value in the pair
     */
    public void setLeft(final K leftSide) {
        this.leftSide = leftSide;
    }

    /**
     * Sets the value of the right-side value in the pair.
     *
     * @param rightSide the value to use as the right-side value in the pair
     */
    public void setRight(final V rightSide) {
        this.rightSide = rightSide;
    }

    /**
     * Returns the value of the left-side value in the pair.
     *
     * @return the left-side value in the pair
     */
    public K getLeft() {
        return leftSide;
    }

    /**
     * Returns the value of the right-side value in the pair.
     *
     * @return the right-side value in the pair
     */
    public V getRight() {
        return rightSide;
    }

    public Object[] toArray() {
        return new Object[]{getLeft(), getRight()};
    }

    /**
     * Compares this pair to another object for equality.
     *
     * @param o the object to compare to
     *
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(leftSide, pair.leftSide) &&
               Objects.equals(rightSide, pair.rightSide);
    }

    /**
     * Computes a hash code for this pair.
     *
     * @return the hash code for this pair
     */
    @Override
    public int hashCode() {
        return Objects.hash(leftSide, rightSide);
    }

    /**
     * Returns a string representation of this pair.
     *
     * @return a string representation of this pair
     */
    @Override
    public String toString() {
        return String.format("Pair(%s, %s)", leftSide, rightSide);
    }
}
