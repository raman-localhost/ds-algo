package com.example.ds.exceptions;

public class StackEmptyException extends RuntimeException{

    public static final String STACK_IS_EMPTY = "Stack is empty";

    public StackEmptyException(String message) {
        super(message);
    }
}
