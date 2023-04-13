package com.beastlymc.data.tree;

/**
 * This interface represents a Tree that stores elements of type E.
 * <p>
 * A tree is a collection of elements that is organized in a hierarchical manner,
 * <p>
 * where each element (except for the root) has a parent and zero or more children.
 *
 * @param <E> the type of elements stored in the Tree.
 */
public interface Tree<E> {

    /**
     * Adds the specified element to the tree.
     *
     * @param element the element to add to the tree.
     */
    void add(final E element);

    boolean isEmpty();

    /**
     * Returns the height of the tree.
     * The height of the tree is defined as the number of levels in the tree.
     * A tree with a single node has a height of 1.
     *
     * @return the height of the tree.
     */
    int getHeight();

    void setHead(final E head);

    /**
     * Sets the left subtree of the tree to the specified tree.
     *
     * @param tree the tree to set as the left subtree
     */
    void setLeftTree(final Tree<E> tree);

    /**
     * Sets the right subtree of the tree to the specified tree.
     *
     * @param tree the tree to set as the right subtree
     */

    void setRightTree(final Tree<E> tree);

    /**
     * Returns the element at the head of the tree.
     * The head of the tree is the root node of the tree.
     *
     * @return the element at the head of the tree.
     */
    E getHead();

    /**
     * @return the left subtree of the tree
     */
    Tree<E> getLeftTree();

    /**
     * @return the right subtree of the tree
     */
    Tree<E> getRightTree();
}