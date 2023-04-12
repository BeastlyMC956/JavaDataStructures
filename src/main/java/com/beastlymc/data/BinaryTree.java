package com.beastlymc.data;

/**
 * The BinaryTree class is a concrete implementation of the AbstractBinaryTree class that represents a binary tree data structure with elements of type E.
 *
 * @param <E> the type of elements stored in the BinaryTree.
 */
public class BinaryTree<E> extends AbstractBinaryTree<E> {

    private E head;
    private BinaryTree<E> left;
    private BinaryTree<E> right;

    /**
     * Constructs a new BinaryTree with the specified head element, left subtree, and right subtree.
     *
     * @param head  the head element of the BinaryTree
     * @param left  the left subtree of the BinaryTree
     * @param right the right subtree of the BinaryTree
     */
    public BinaryTree(E head, BinaryTree<E> left, BinaryTree<E> right) {
        super(head, left, right);
        this.head = head;
        this.left = left;
        this.right = right;
    }

    /**
     * Constructs a new BinaryTree with the specified head element and empty subtrees.
     *
     * @param head the head element of the BinaryTree
     */
    public BinaryTree(E head) {
        this(head, null, null);
    }

    /**
     * Adds the specified element to the BinaryTree.
     *
     * @param element the element to add to the BinaryTree
     */
    @Override
    public void add(E element) {
        if (this.head == null) {
            this.head = element;
            return;
        }

        if (left == null) {
            left = new BinaryTree<>(element);
        } else if (right == null) {
            right = new BinaryTree<>(element);
        } else {
            Queue<BinaryTree<E>> leftQueue = new Queue<>();
            Queue<BinaryTree<E>> rightQueue = new Queue<>();
            leftQueue.offer(left);
            rightQueue.offer(right);
            while (!leftQueue.isEmpty() || !rightQueue.isEmpty()) {
                if (checkTree(element, leftQueue)) {
                    return;
                }
                if (checkTree(element, rightQueue)) {
                    return;
                }
            }
        }
    }

    /**
     * Helper method to check the BinaryTree for a spot to add the specified element.
     *
     * @param element the element to add to the BinaryTree
     * @param queue   the queue of BinaryTrees to check
     *
     * @return true if the element was added to the BinaryTree, false otherwise
     */
    private boolean checkTree(E element, Queue<BinaryTree<E>> queue) {
        if (!queue.isEmpty()) {
            BinaryTree<E> current = queue.poll();
            if (current.getLeftTree() == null) {
                current.setLeftTree(new BinaryTree<>(element));
                return true;
            } else if (current.getRightTree() == null) {
                current.setRightTree(new BinaryTree<>(element));
                return true;
            } else {
                queue.offer((BinaryTree<E>) current.getLeftTree());
                queue.offer((BinaryTree<E>) current.getRightTree());
            }
        }
        return false;
    }
}
