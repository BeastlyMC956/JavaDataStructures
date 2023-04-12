package com.beastlymc.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    @Test
    void testBinarySearchTreeOperations() {
        AbstractBinaryTree<Integer> tree = new BinarySearchTree<>(50);

        tree.add(30);
        tree.add(70);
        tree.add(20);
        tree.add(40);
        tree.add(60);
        tree.add(80);

        assertEquals(50, tree.getHead());
        assertEquals(30, tree.getLeftTree().getHead());
        assertEquals(70, tree.getRightTree().getHead());
        assertEquals(20, tree.getLeftTree().getLeftTree().getHead());
        assertEquals(40, tree.getLeftTree().getRightTree().getHead());
        assertEquals(60, tree.getRightTree().getLeftTree().getHead());
        assertEquals(80, tree.getRightTree().getRightTree().getHead());

        assertEquals(3, tree.getHeight());
    }

}