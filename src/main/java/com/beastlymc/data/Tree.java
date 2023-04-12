package com.beastlymc.data;

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
    void add(E element);

    /**
     * Returns the height of the tree.
     * The height of the tree is defined as the number of levels in the tree.
     * A tree with a single node has a height of 1.
     *
     * @return the height of the tree.
     */
    int getHeight();

    /**
     * Returns the element at the head of the tree.
     * The head of the tree is the root node of the tree.
     *
     * @return the element at the head of the tree.
     */
    E getHead();

    /**
     * Sets the left subtree of the tree to the specified tree.
     *
     * @param tree the tree to set as the left subtree
     */
    void setLeftTree(Tree<E> tree);

    /**
     * Sets the right subtree of the tree to the specified tree.
     *
     * @param tree the tree to set as the right subtree
     */

    void setRightTree(Tree<E> tree);

    /**
     * @return the left subtree of the tree
     */
    Tree<E> getLeftTree();

    /**
     * @return the right subtree of the tree
     */
    Tree<E> getRightTree();
}