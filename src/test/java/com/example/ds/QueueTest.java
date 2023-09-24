package com.example.ds;

import com.example.ds.exceptions.QueueEmptyException;
import com.example.ds.exceptions.QueueFullException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    Queue queue;

    @BeforeEach
    void setup() {
        queue = new Queue(5);
    }

    @AfterEach
    void teardown() {
        queue = null;
    }

    @Test
    void isEmptyShouldReturnTrueForEmptyQueue() {
        assertTrue(queue.isEmpty());
    }

    @Test
    void isEmptyShouldReturnFalseForNonEmptyQueue() {
        queue.enqueue(100);
        assertFalse(queue.isEmpty());
    }

    @Test
    void isFullShouldReturnTrueForFullQueue() {
        fillQueue();
        assertTrue(queue.isFull());
    }

    @Test
    void isFullShouldReturnFalseForNonFullQueue() {
        queue.enqueue(15);
        ;
        assertFalse(queue.isFull());
    }

    private void fillQueue() {
        Random random = new Random();
        for (int i = 0; i < queue.getMaxSize(); i++) {
            queue.enqueue(random.nextInt(100));
        }// end for
    }

    @Test
    void enqueueShouldAddElementToQueue() {
        queue.enqueue(5);
        int value = 15;
        queue.enqueue(value);

        assertEquals(value, queue.peekRear());
    }

    @Test
    void enqueueShouldThrowQueueFullExceptionUponAddingToFullQueue() {
        fillQueue();

        int value = 500;
        var queueFullException = assertThrows(QueueFullException.class, () -> {
            queue.enqueue(value);
        });

        assertEquals(QueueFullException.QUEUE_FULL_MSG, queueFullException.getMessage());
    }

    @Test
    void dequeueShouldReturnFirstElementInQueue() {
        fillQueue();

        int value = queue.peekFront();
        int dequeued = queue.dequeue();

        assertEquals(value, dequeued);
    }

    @Test
    void dequeueShouldThrowQueueEmptyExceptionUponRemovalFromEmptyQueue(){
        var queueEmptyException = assertThrows(QueueEmptyException.class, () -> queue.dequeue());
        assertEquals(QueueEmptyException.QUEUE_EMPTY_MSG, queueEmptyException.getMessage());
    }

}