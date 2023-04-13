package com.beastlymc.data.tree;

/**
 * A class representing a binary search tree data structure.
 *
 * @param <T> the type of elements stored in the binary search tree
 *
 * @see Comparable
 */
public class BinarySearchTree<T extends Comparable<T>> extends AbstractBinaryTree<T> {

    /**
     * Initializes an empty binary search tree.
     */
    public BinarySearchTree() {
        super();
    }

    /**
     * Inserts a new element into the binary search tree.
     *
     * @param data the element to insert
     */
    @Override
    public void insert(final T data) {
        Node<T> newNode = new Node<>(data);

        if (root == null) {
            root = newNode;
            return;
        }

        Node<T> currentNode = root;

        while (true) {
            if (data.compareTo(currentNode.data) < 0) {
                if (currentNode.leftChild == null) {
                    currentNode.leftChild = newNode;
                    return;
                } else {
                    currentNode = currentNode.leftChild;
                }
            } else {
                if (currentNode.rightChild == null) {
                    currentNode.rightChild = newNode;
                    return;
                } else {
                    currentNode = currentNode.rightChild;
                }
            }
        }
    }

    /**
     * Searches for an element in the binary search tree.
     *
     * @param data the element to search for
     *
     * @return true if the element is found, false otherwise
     */
    @Override
    public boolean search(final T data) {
        Node<T> currentNode = root;

        while (currentNode != null) {
            if (data.compareTo(currentNode.data) < 0) {
                currentNode = currentNode.leftChild;
            } else if (data.compareTo(currentNode.data) > 0) {
                currentNode = currentNode.rightChild;
            } else {
                return true;
            }
        }

        return false;
    }

    /**
     * Deletes an element from the binary search tree.
     *
     * @param data the element to delete
     */
    @Override
    public void delete(final T data) {
        root = delete(root, data);
    }

    /**
     * Deletes a node with the specified element from the binary search tree rooted at the specified node.
     *
     * @param node the root node of the binary search tree to delete from
     * @param data the element to delete
     *
     * @return the root node of the modified binary search tree
     */
    private Node<T> delete(Node<T> node, final T data) {
        if (node == null) {
            return null;
        }

        if (data.compareTo(node.data) < 0) {
            node.leftChild = delete(node.leftChild, data);
        } else if (data.compareTo(node.data) > 0) {
            node.rightChild = delete(node.rightChild, data);
        } else {
            if (node.leftChild == null && node.rightChild == null) {
                node = null;
            } else if (node.leftChild == null) {
                node = node.rightChild;
            } else if (node.rightChild == null) {
                node = node.leftChild;
            } else {
                Node<T> minRightNode = findMin(node.rightChild);
                node.data = minRightNode.data;
                node.rightChild = delete(node.rightChild, minRightNode.data);
            }
        }

        return node;
    }

    /**
     * Finds the node with the minimum value in the binary search tree rooted at the specified node.
     *
     * @param node the root node of the binary search tree to search in
     *
     * @return the node with the minimum value in the binary search tree
     */
    private Node<T> findMin(Node<T> node) {
        while (node.leftChild != null) {
            node = node.leftChild;
        }

        return node;
    }
}
