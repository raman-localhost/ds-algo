package com.example.ds.exceptions;

public class QueueFullException extends RuntimeException {

    public static  final String QUEUE_FULL_MSG = "Queue is Full";

    public QueueFullException(String message) {
        super(message);
    }
}
