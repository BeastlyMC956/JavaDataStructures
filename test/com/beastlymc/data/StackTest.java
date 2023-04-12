package com.beastlymc.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    void testStackOperations() {
        Stack<Integer> stack = new Stack<>(4);

        assertTrue(stack.isEmpty());

        assertThrows(IllegalStateException.class, stack::pop);
        assertThrows(IllegalStateException.class, stack::peek);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        assertTrue(stack.isFull());
        assertFalse(stack.isEmpty());

        assertThrows(IllegalStateException.class, () -> stack.push(5));

        assertEquals(4, stack.peek());
        assertEquals(4, stack.pop());


        assertFalse(stack.isFull());

    }

}