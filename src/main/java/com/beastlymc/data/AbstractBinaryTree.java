package com.beastlymc.data;

/**
 * The AbstractBinaryTree class provides an abstract implementation of the Tree interface and represents a binary tree data structure with elements of type E.
 *
 * @param <E> the type of elements stored in the BinaryTree.
 */
public abstract class AbstractBinaryTree<E> implements Tree<E> {

    private final E head;
    private AbstractBinaryTree<E> left;
    private AbstractBinaryTree<E> right;

    /**
     * Constructs a binary tree with the specified head, left subtree, and right subtree.
     *
     * @param head  the head element of the binary tree
     * @param left  the left subtree of the binary tree
     * @param right the right subtree of the binary tree
     */
    protected AbstractBinaryTree(E head, AbstractBinaryTree<E> left, AbstractBinaryTree<E> right) {
        this.head = head;
        this.left = left;
        this.right = right;
    }

    /**
     * @return the height of the binary tree
     */
    @Override
    public int getHeight() {
        if (head == null) {
            return 0;
        }

        int leftHeight = (left == null)
                         ? 0
                         : left.getHeight();
        int rightHeight = (right == null)
                          ? 0
                          : right.getHeight();
        return 1 + Math.max(leftHeight, rightHeight);
    }

    /**
     * @return the head element of the binary tree
     */
    @Override
    public E getHead() {
        return head;
    }

    /**
     * Sets the left subtree of the binary tree.
     *
     * @param tree the left subtree of the binary tree
     */
    @Override
    public void setLeftTree(Tree<E> tree) {
        this.left = (BinaryTree<E>) tree;
    }

    /**
     * Sets the right subtree of the binary tree.
     *
     * @param tree the right subtree of the binary tree
     */
    @Override
    public void setRightTree(Tree<E> binaryTree) {
        this.right = (BinaryTree<E>) binaryTree;
    }

    /**
     * @return the left subtree of the binary tree
     */
    @Override
    public Tree<E> getLeftTree() {
        return left;
    }

    /**
     * @return the right subtree of the binary tree
     */
    @Override
    public Tree<E> getRightTree() {
        return right;
    }

    /**
     * @return a string representation of the binary tree
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        toStringHelper(sb, "", "", this);
        return sb.toString();
    }

    /**
     * Helper method for generating the string representation of the binary tree.
     *
     * @param sb             the StringBuilder object to append the tree nodes to
     * @param prefix         the prefix string for the current node
     * @param childrenPrefix the prefix string for the current node's children
     * @param node           the current node to append to the StringBuilder
     */
    private void toStringHelper(StringBuilder sb, String prefix, String childrenPrefix, AbstractBinaryTree<E> node) {
        sb.append(prefix);
        sb.append(node.getHead());
        sb.append("\n");
        if (node.getLeftTree() != null) {
            toStringHelper(sb, childrenPrefix + "├── ", childrenPrefix + "│   ",
                           (AbstractBinaryTree<E>) node.getLeftTree());
        }
        if (node.getRightTree() != null) {
            toStringHelper(sb, childrenPrefix + "└── ", childrenPrefix + "    ",
                           (AbstractBinaryTree<E>) node.getRightTree());
        }
    }
}
