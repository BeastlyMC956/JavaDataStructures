package com.beastlymc.data.queues;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    private Queue<String> queue;

    @BeforeEach
    void setUp() {
        queue = new Queue<>();
    }

    @Test
    void push() {
        queue.push("hello");
        queue.push("world");

        assertEquals(2, queue.size());
        assertEquals("hello", queue.peek().orElse(null));
    }

    @Test
    void pop() {
        assertEquals(Optional.empty(), queue.pop());

        queue.push("hello");
        queue.push("world");

        assertEquals("hello", queue.pop().orElse(null));
        assertEquals("world", queue.pop().orElse(null));
        assertEquals(Optional.empty(), queue.pop());
    }

    @Test
    void peek() {
        assertEquals(Optional.empty(), queue.peek());

        queue.push("hello");
        queue.push("world");

        assertEquals("hello", queue.peek().orElse(null));
        assertEquals(2, queue.size());
    }

    @Test
    void clear() {
        queue.push("hello");
        queue.push("world");

        queue.clear();

        assertEquals(0, queue.size());
        assertEquals(Optional.empty(), queue.peek());
        assertEquals(Optional.empty(), queue.pop());
    }

    @Test
    void contains() {
        queue.push("hello");
        queue.push("world");

        assertTrue(queue.contains("hello"));
        assertTrue(queue.contains("world"));
        assertFalse(queue.contains("java"));
    }

    @Test
    void size() {
        assertEquals(0, queue.size());

        queue.push("hello");
        queue.push("world");

        assertEquals(2, queue.size());
    }

    @Test
    void iterator() {
        queue.push("hello");
        queue.push("world");

        StringBuilder sb = new StringBuilder();
        for (String s : queue) {
            sb.append(s);
        }

        assertEquals("helloworld", sb.toString());
    }

    @Test
    void toStringTest() {
        queue.push("hello");
        queue.push("world");

        assertEquals("Queue{list=[hello, world]}", queue.toString());
    }

}
