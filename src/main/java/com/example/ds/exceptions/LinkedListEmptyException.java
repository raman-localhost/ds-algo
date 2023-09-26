package com.example.ds.exceptions;

public class LinkedListEmptyException extends RuntimeException {

    public static final String LINKED_LIST_EMPTY_MESSAGE = "LinkedList is empty";

    public LinkedListEmptyException(String message) {
        super(message);
    }
}
