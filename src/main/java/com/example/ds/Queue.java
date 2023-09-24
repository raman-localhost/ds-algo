package com.example.ds;

import com.example.ds.exceptions.QueueEmptyException;
import com.example.ds.exceptions.QueueFullException;

import static com.example.ds.exceptions.QueueEmptyException.QUEUE_EMPTY_MSG;
import static com.example.ds.exceptions.QueueFullException.QUEUE_FULL_MSG;

public class Queue {

    private final int[] data;
    private int front;
    private int rear = -1;

    private int count;

    private final int maxSize;

    public Queue(int maxSize) {
        this.maxSize = maxSize;
        this.data = new int[maxSize];
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public boolean isFull(){
        return count == maxSize;
    }

    public void enqueue(int value){
        if(isFull())
            throw new QueueFullException(QUEUE_FULL_MSG);

        //wrap rear around if it reaches the last index
        if(rear == maxSize - 1)
            rear = -1;

        data[++rear] = value;
        count++;
    }

    public int peekFront(){
        if(isEmpty())
            throw new QueueEmptyException(QUEUE_EMPTY_MSG);

        return data[front];
    }

    public int peekRear(){
        if(isEmpty())
            throw new QueueEmptyException(QUEUE_EMPTY_MSG);

        return data[rear];
    }

    public int dequeue(){

        if(isEmpty())
            throw new QueueEmptyException(QUEUE_EMPTY_MSG);

        // wrap front around if it goes beyond the last index
        if(front == maxSize)
            front = 0;

        int value = data[front++];
        count--;

        return value;
    }

    public  int count(){
        return count;
    }

    public int getMaxSize() {
        return maxSize;
    }

}
