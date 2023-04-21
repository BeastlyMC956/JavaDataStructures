package com.beastlymc.data.stacks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    private Stack<Integer> stack;

    @BeforeEach
    void setUp() {
        stack = new Stack<>(3);
    }

    @Test
    void testPush() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertThrows(IllegalStateException.class, () -> stack.push(4));
    }

    @Test
    void testPop() {
        assertTrue(stack.pop().isEmpty());
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(Optional.of(1), stack.pop());
        assertEquals(Optional.of(2), stack.pop());
        assertEquals(Optional.of(3), stack.pop());
        assertTrue(stack.pop().isEmpty());
    }

    @Test
    void testPeek() {
        assertTrue(stack.peek().isEmpty());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(Optional.of(3), stack.peek());
        assertEquals(Optional.of(3), stack.peek());
    }

    @Test
    void testSize() {
        assertEquals(0, stack.size());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.size());
    }

    @Test
    void testClear() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.clear();
        assertEquals(0, stack.size());
        assertTrue(stack.peek().isEmpty());
    }

    @Test
    void testContains() {
        assertFalse(stack.contains(1));

        stack.push(1);

        assertTrue(stack.contains(1));
        stack.push(2);
        
        stack.push(3);
        assertTrue(stack.contains(2));
        assertTrue(stack.contains(3));
        assertFalse(stack.contains(4));
    }

    @Test
    void testIterator() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        StringBuilder sb = new StringBuilder();
        for (Integer i : stack) {
            sb.append(i).append(",");
        }
        assertEquals("3,2,1,", sb.toString());
    }
}
