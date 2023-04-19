package com.beastlymc.data.trees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    @Test
    void testAbstractBinaryTreeInsert() {
        AbstractBinaryTree<Integer> tree = new BinaryTree<>();
        assertTrue(tree.isEmpty());
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);

        assertFalse(tree.isEmpty());

        assertEquals("""
                              1 \s
                             2 3\s
                                    \s
                             """, tree.toString());

        assertTrue(tree.search(1));
        assertTrue(tree.search(2));
        assertTrue(tree.search(3));
    }

    @Test
    void testAbstractBinaryTreeSearch() {
        AbstractBinaryTree<Integer> tree = new BinaryTree<>();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        assertTrue(tree.search(1));
        assertTrue(tree.search(2));
        assertTrue(tree.search(3));
        assertFalse(tree.search(4));
    }

    @Test
    void testAbstractBinaryTreeDelete() {
        AbstractBinaryTree<Integer> tree = new BinaryTree<>();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.delete(2);
        assertTrue(tree.search(1));
        assertFalse(tree.search(2));
        assertTrue(tree.search(3));
    }

    @Test
    void testBinaryTreeInsert() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        assertTrue(tree.search(1));
        assertTrue(tree.search(2));
        assertTrue(tree.search(3));
    }

    @Test
    void testBinaryTreeSearch() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        assertTrue(tree.search(1));
        assertTrue(tree.search(2));
        assertTrue(tree.search(3));
        assertFalse(tree.search(4));
    }

    @Test
    void testBinaryTreeDelete() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.delete(2);
        assertTrue(tree.search(1));
        assertFalse(tree.search(2));
        assertTrue(tree.search(3));
    }

    @Test
    void testBinarySearchTreeInsert() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(2);
        tree.insert(1);
        tree.insert(3);
        assertTrue(tree.search(1));
        assertTrue(tree.search(2));
        assertTrue(tree.search(3));
    }

    @Test
    void testBinarySearchTreeSearch() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(2);
        tree.insert(1);
        tree.insert(3);
        assertTrue(tree.search(1));
        assertTrue(tree.search(2));
        assertTrue(tree.search(3));
        assertFalse(tree.search(4));
    }

    @Test
    void testBinarySearchTreeDelete() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(2);
        tree.insert(1);
        tree.insert(3);
        tree.delete(2);
        assertTrue(tree.search(1));
        assertFalse(tree.search(2));
        assertTrue(tree.search(3));
    }

}
