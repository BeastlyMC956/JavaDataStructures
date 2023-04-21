package com.beastlymc.data.trees;

import com.beastlymc.data.queues.Queue;

import java.util.Optional;

/**
 * The BinaryTree class is a concrete implementation of the AbstractBinaryTree
 * class that represents a binary tree data structure with elements of type E.
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
        queue.push(root);

        while (!queue.isEmpty()) {
            Optional<Node<T>> currentNode = queue.pop();

            if (currentNode.isEmpty()) {
                continue;
            }

            if (currentNode.get().leftChild == null) {
                currentNode.get().leftChild = newNode;
                return;
            } else {
                queue.push(currentNode.get().leftChild);
            }

            if (currentNode.get().rightChild == null) {
                currentNode.get().rightChild = newNode;
                return;
            } else {
                queue.push(currentNode.get().rightChild);
            }
        }
    }

    @Override
    public boolean search(final T data) {
        if (root == null) {
            return false;
        }

        Queue<Node<T>> queue = new Queue<>();
        queue.push(root);

        while (!queue.isEmpty()) {
            Optional<Node<T>> currentNode = queue.pop();

            if (currentNode.isEmpty()) {
                continue;
            }

            if (currentNode.get().data.equals(data)) {
                return true;
            }

            if (currentNode.get().leftChild != null) {
                queue.push(currentNode.get().leftChild);
            }

            if (currentNode.get().rightChild != null) {
                queue.push(currentNode.get().rightChild);
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
        queue.push(root);

        Node<T> nodeToDelete = null;
        Node<T> deepestNode = null;

        while (!queue.isEmpty()) {
            Optional<Node<T>> currentNode = queue.pop();

            if (currentNode.isEmpty()) {
                continue;
            }

            if (currentNode.get().data.equals(data)) {
                nodeToDelete = currentNode.get();
            }

            if (currentNode.get().leftChild != null) {
                queue.push(currentNode.get().leftChild);
                deepestNode = currentNode.get().leftChild;
            }

            if (currentNode.get().rightChild != null) {
                queue.push(currentNode.get().rightChild);
                deepestNode = currentNode.get().rightChild;
            }
        }

        if (nodeToDelete != null) {
            nodeToDelete.data = deepestNode.data;

            queue.clear();
            queue.push(root);

            while (!queue.isEmpty()) {
                Optional<Node<T>> currentNode = queue.pop();

                if (currentNode.isEmpty()) {
                    continue;
                }

                if (currentNode.get().leftChild != null) {
                    if (currentNode.get().leftChild == deepestNode) {
                        currentNode.get().leftChild = null;
                        return;
                    } else {
                        queue.push(currentNode.get().leftChild);
                    }
                }

                if (currentNode.get().rightChild != null) {
                    if (currentNode.get().rightChild == deepestNode) {
                        currentNode.get().rightChild = null;
                        return;
                    } else {
                        queue.push(currentNode.get().rightChild);
                    }
                }
            }
        }
    }
}
