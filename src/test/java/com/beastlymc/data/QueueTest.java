package com.beastlymc.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    @Test
    void testQueueOperations() {
        Queue<Integer> queue = new Queue<>();

        assertTrue(queue.isEmpty());
        assertNull(queue.peek());
        assertNull(queue.poll());

        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        assertFalse(queue.isEmpty());
        assertEquals(1, queue.peek());

        assertEquals(1, queue.poll());
        assertEquals(2, queue.peek());

        queue.offer(4);
        assertEquals(2, queue.peek());

        assertEquals(2, queue.poll());
        assertEquals(3, queue.peek());

        assertEquals("Queue{list=[3, 4]}", queue.toString());
    }

}