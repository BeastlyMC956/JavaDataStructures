package com.beastlymc.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    @Test
    void testBinaryTreeOperations() {
        AbstractBinaryTree<Integer> empty = new BinaryTree<>(null);
        assertEquals(0, empty.getHeight());

        BinaryTree<Integer> tree = new BinaryTree<>(1);

        tree.add(2);
        tree.add(3);

        assertEquals(1, tree.getHead());
        assertEquals(2, tree.getLeftTree().getHead());
        assertEquals(3, tree.getRightTree().getHead());

        tree.add(4);
        tree.add(5);

        assertEquals(4, tree.getLeftTree().getLeftTree().getHead());
        assertEquals(5, tree.getLeftTree().getRightTree().getHead());

        assertEquals(3, tree.getHeight());
    }

}