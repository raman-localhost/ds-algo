package com.example.ds;

import com.example.ds.exceptions.StackEmptyException;
import com.example.ds.exceptions.StackFullException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.OptionalInt;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    private Stack stack;

    @BeforeEach
    public void setup() {
        stack = new Stack(5);
    }

    @AfterEach
    public void teardown() {
        stack = null;
    }

    @Test
    void shouldReturnTrueForEmptyStack() {
        assertTrue(stack.isEmpty());
    }

    @Test
    void shouldThrowExceptionForPoppingFromEmptyStack() {
        var stackEmptyException = assertThrows(StackEmptyException.class, () -> stack.pop());
        assertEquals(StackEmptyException.STACK_IS_EMPTY, stackEmptyException.getMessage());
    }

    @Test
    void shouldReturnZeroSizeForEmptyStack() {
        int size = stack.size();

        assertEquals(0, size);
    }

    @Test
    void shouldAddElementToTopOfStack() {
        int value = 1;
        stack.push(value);
        assertEquals(value, stack.peek().getAsInt());
    }

    @Test
    void shouldThrowStackFullExceptionUponPushingToFullStack() {
        Random random = fillStack();

        var stackFullException = assertThrows(StackFullException.class, () -> stack.push(random.nextInt()));
        assertEquals(StackFullException.STACK_IS_FULL, stackFullException.getMessage());
    }

    private Random fillStack() {
        Random random = new Random();
        for (int i = 0; i < stack.getMaxSize(); i++) {
            stack.push(random.nextInt(100));
        }
        return random;
    }


    @Test
    void shouldReturnElementFromTopOfTheStack() {
        int value = 10;
        stack.push(value);

        OptionalInt peek = stack.peek();

        assertEquals(value, peek.getAsInt());
    }

    @Test
    void shouldReturnEmptyOptionalWhilePeekingFromEmptyStack() {
        assertEquals(OptionalInt.empty(), stack.peek());
    }

    @Test
    void shouldThrowStackEmptyExceptionForPoppingFromEmptyStack() {
        var stackEmptyException = assertThrows(StackEmptyException.class, () -> stack.pop());
        assertEquals(StackEmptyException.STACK_IS_EMPTY, stackEmptyException.getMessage());
    }

    @Test
    void shouldRemoveElementFromTopOfStack() {
        int value = 20;
        stack.push(value);
        int currentSize = stack.size();

        int pop = stack.pop();

        assertEquals(value, pop);
        assertEquals(currentSize - 1, stack.size());

    }

}