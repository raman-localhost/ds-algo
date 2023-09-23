package com.example.ds.exceptions;

public class StackFullException extends RuntimeException{

    public static final String STACK_IS_FULL = "Stack is full";

    public StackFullException(String message) {
        super(message);
    }
}
