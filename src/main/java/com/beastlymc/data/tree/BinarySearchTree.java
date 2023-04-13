package com.beastlymc.data.tree;

/**
 * The BinarySearchTree class represents a binary search tree data structure that stores elements of type E in sorted order.
 * <p>
 * The elements must implement the Comparable interface in order to be stored in the BinarySearchTree.
 *
 * @param <E> the type of elements stored in the BinarySearchTree.
 *
 * @see Tree
 * @see Comparable
 */
public class BinarySearchTree<E extends Comparable<E>> extends AbstractBinaryTree<E> {

    private E head;
    private BinarySearchTree<E> left;
    private BinarySearchTree<E> right;

    /**
     * Constructs a new BinarySearchTree with the specified head element, left subtree, and right subtree.
     *
     * @param head  the head element of the BinarySearchTree
     * @param left  the left subtree of the BinarySearchTree
     * @param right the right subtree of the BinarySearchTree
     */
    public BinarySearchTree(final E head, final BinarySearchTree<E> left, final BinarySearchTree<E> right) {
        super(head, left, right);
        this.head = head;
        this.left = left;
        this.right = right;
    }


    /**
     * Constructs a new BinarySearchTree with the specified head element and empty subtrees.
     *
     * @param head the head element of the BinarySearchTree
     */
    public BinarySearchTree(final E head) {
        this(head, null, null);
    }

    /**
     * Adds the specified element to the BinarySearchTree in sorted order.
     *
     * @param element the element to add to the BinarySearchTree
     */
    @Override
    public void add(final E element) {
        if (head == null) {
            head = element;
            return;
        }

        int comparison = element.compareTo(head);

        if (comparison < 0) {
            if (left == null) {
                left = new BinarySearchTree<>(element);
            } else {
                left.add(element);
            }
        } else if (comparison > 0) {
            if (right == null) {
                right = new BinarySearchTree<>(element);
            } else {
                right.add(element);
            }
        }
    }

    @Override
    public void setHead(final E head) {
        this.head = head;
    }

    @Override
    public void setLeftTree(final Tree<E> tree) {
        this.left = (BinarySearchTree<E>) tree;
    }

    @Override
    public void setRightTree(final Tree<E> tree) {
        this.right = (BinarySearchTree<E>) tree;
    }

    @Override
    public Tree<E> getLeftTree() {
        return left;
    }

    @Override
    public Tree<E> getRightTree() {
        return right;
    }

    @Override
    public E getHead() {
        return head;
    }
}
