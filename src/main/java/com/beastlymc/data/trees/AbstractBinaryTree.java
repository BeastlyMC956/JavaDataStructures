package com.beastlymc.data.trees;

import com.beastlymc.data.queues.Queue;

/**
 * An abstract class representing a binary tree data structure.
 *
 * @param <T> the type of elements stored in the binary tree
 */
public abstract class AbstractBinaryTree<T> {

    /**
     * The root node of the binary tree.
     */
    protected Node<T> root;

    /**
     * Initializes an empty binary tree.
     */
    protected AbstractBinaryTree() {
        this.root = null;
    }

    /**
     * Inserts a new element into the binary tree.
     *
     * @param data the element to insert
     */
    public abstract void insert(final T data);

    /**
     * Searches for an element in the binary tree.
     *
     * @param data the element to search for
     *
     * @return true if the element is found, false otherwise
     */
    public abstract boolean search(final T data);

    /**
     * Deletes an element from the binary tree.
     *
     * @param data the element to delete
     */
    public abstract void delete(final T data);

    /**
     * Checks whether the tree is empty
     *
     * @return true if the tree is empty, false otherwise
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Returns a string representation of the binary tree.
     *
     * @return a string representation of the binary tree
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (root == null) {
            return sb.toString();
        }

        Queue<Node<T>> queue = new Queue<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                Node<T> currentNode = queue.poll();

                if (currentNode == null) {
                    sb.append("  ");
                } else {
                    sb.append(currentNode.data.toString()).append(" ");

                    queue.offer(currentNode.leftChild);
                    queue.offer(currentNode.rightChild);
                }
            }

            sb.append("\n");
        }

        String[] lines = sb.toString().split("\n");
        int maxWidth = lines[lines.length - 2].length();
        sb = new StringBuilder();

        for (String line : lines) {
            sb.append(padLine(line, maxWidth)).append("\n");
        }

        return sb.toString();
    }

    private String padLine(String line, int maxWidth) {
        int lineLength = line.length();

        if (lineLength < maxWidth) {
            int diff = maxWidth - lineLength;
            int leftPadding = diff / 2;
            int rightPadding = diff - leftPadding;
            return " ".repeat(leftPadding) + line + " ".repeat(rightPadding);
        } else {
            return line;
        }
    }

    /**
     * A nested class representing a node in the binary tree.
     *
     * @param <T> the type of element stored in the node
     */
    protected static class Node<T> {

        /**
         * The element stored in the node.
         */
        protected T data;

        /**
         * The left child node of the node.
         */
        protected Node<T> leftChild;

        /**
         * The right child node of the node.
         */
        protected Node<T> rightChild;

        /**
         * Initializes a new node with the specified element.
         *
         * @param data the element to store in the node
         */
        public Node(T data) {
            this.data = data;
            this.leftChild = null;
            this.rightChild = null;
        }
    }
}
