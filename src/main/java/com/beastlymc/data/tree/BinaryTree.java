package com.beastlymc.data.tree;

import com.beastlymc.data.Queue;

/**
 * The BinaryTree class is a concrete implementation of the AbstractBinaryTree class that represents a binary tree data structure with elements of type E.
 *
 * @param <T> the type of elements stored in the BinaryTree.
 */
public class BinaryTree<T> extends AbstractBinaryTree<T> {
    public BinaryTree() {
        super();
    }

    @Override
    public void insert(final T data) {
        Node<T> newNode = new Node<>(data);

        if (root == null) {
            root = newNode;
            return;
        }

        Queue<Node<T>> queue = new Queue<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node<T> currentNode = queue.poll();

            if (currentNode.leftChild == null) {
                currentNode.leftChild = newNode;
                return;
            } else {
                queue.offer(currentNode.leftChild);
            }

            if (currentNode.rightChild == null) {
                currentNode.rightChild = newNode;
                return;
            } else {
                queue.offer(currentNode.rightChild);
            }
        }
    }

    @Override
    public boolean search(final T data) {
        if (root == null) {
            return false;
        }

        Queue<Node<T>> queue = new Queue<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node<T> currentNode = queue.poll();

            if (currentNode.data.equals(data)) {
                return true;
            }

            if (currentNode.leftChild != null) {
                queue.offer(currentNode.leftChild);
            }

            if (currentNode.rightChild != null) {
                queue.offer(currentNode.rightChild);
            }
        }

        return false;
    }

    @Override
    public void delete(final T data) {
        if (root == null) {
            return;
        }

        Queue<Node<T>> queue = new Queue<>();
        queue.offer(root);

        Node<T> nodeToDelete = null;
        Node<T> deepestNode = null;

        while (!queue.isEmpty()) {
            Node<T> currentNode = queue.poll();

            if (currentNode.data.equals(data)) {
                nodeToDelete = currentNode;
            }

            if (currentNode.leftChild != null) {
                queue.offer(currentNode.leftChild);
                deepestNode = currentNode.leftChild;
            }

            if (currentNode.rightChild != null) {
                queue.offer(currentNode.rightChild);
                deepestNode = currentNode.rightChild;
            }
        }

        if (nodeToDelete != null) {
            nodeToDelete.data = deepestNode.data;

            queue.clear();
            queue.offer(root);

            while (!queue.isEmpty()) {
                Node<T> currentNode = queue.poll();

                if (currentNode.leftChild != null) {
                    if (currentNode.leftChild == deepestNode) {
                        currentNode.leftChild = null;
                        return;
                    } else {
                        queue.offer(currentNode.leftChild);
                    }
                }

                if (currentNode.rightChild != null) {
                    if (currentNode.rightChild == deepestNode) {
                        currentNode.rightChild = null;
                        return;
                    } else {
                        queue.offer(currentNode.rightChild);
                    }
                }
            }
        }
    }
}
