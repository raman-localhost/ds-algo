package com.example.ds;

import com.example.ds.exceptions.StackEmptyException;
import com.example.ds.exceptions.StackFullException;

import javax.swing.text.html.Option;

import java.util.OptionalInt;
import java.util.StringJoiner;

import static com.example.ds.exceptions.StackEmptyException.STACK_IS_EMPTY;
import static com.example.ds.exceptions.StackFullException.STACK_IS_FULL;

public class Stack {

    private final int[] data;
    private final int maxSize;
    private int top = -1;

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        data = new int[maxSize];
    }

    public void push(int value) {

        if (isFull())
            throw new StackFullException(STACK_IS_FULL);

        data[++top] = value;
    }

    public OptionalInt peek() {

        if (isEmpty())
            return OptionalInt.empty();

        return OptionalInt.of(data[top]);
    }

    public int pop() {

        if (isEmpty())
            throw new StackEmptyException(STACK_IS_EMPTY);

        return data[top--];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public int size() {
        return top + 1;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("[]");
            return;
        }

        var sj = new StringJoiner(", ", "[ ", " ]");
        for (int i = 0; i <= top; i++) {
            sj.add(String.valueOf(data[i]));
        }// end for

        System.out.println(sj);
    }

}
