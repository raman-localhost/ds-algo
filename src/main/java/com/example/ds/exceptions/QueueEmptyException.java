package com.example.ds.exceptions;

public class QueueEmptyException extends RuntimeException {
    public static  final String QUEUE_EMPTY_MSG = "Queue is Empty";

    public QueueEmptyException(String message) {
        super(message);
    }
}
