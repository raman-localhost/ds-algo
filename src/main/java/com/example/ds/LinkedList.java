package com.example.ds;

import com.example.ds.exceptions.LinkedListEmptyException;

import java.util.OptionalInt;
import java.util.StringJoiner;

import static com.example.ds.exceptions.LinkedListEmptyException.LINKED_LIST_EMPTY_MESSAGE;

public class LinkedList {

    private int count;
    private Link head;
    private Link tail;

    private static class Link {
        int data;
        Link next;

        public Link(int data, Link next) {
            this.data = data;
            this.next = next;
        }
    }// inner class Link

    public void insertFirst(int value) {

        if (isEmpty()) {
            head = new Link(value, null);
            tail = head;
        } else {
            Link newLink = new Link(value, null);
            newLink.next = head;
            head = newLink;
        }// end if-else

        count++;
    }

    public int peekFirst(){

        if(isEmpty())
            throw new LinkedListEmptyException(LINKED_LIST_EMPTY_MESSAGE);

        return head.data;
    }

    public int peekLast(){

        if(isEmpty())
            throw new LinkedListEmptyException(LINKED_LIST_EMPTY_MESSAGE);

        return tail.data;
    }

    public int deleteFirst() {

        if(isEmpty())
            throw new LinkedListEmptyException(LINKED_LIST_EMPTY_MESSAGE);

        Link temp;
        //only one element in the list, reset both head and tail
        if (count == 1) {
            temp = head;
            head = null;
            tail = null;
        } else {// just move head forward
            temp = head;
            head = head.next;
            temp.next = null;
        }
        count--;
        return temp.data;
    }

    public OptionalInt find(int value){

        if(isEmpty())
            return OptionalInt.empty();

        Link current = head;

        while (current.data !=  value){

            if(current.next == null)// we have reached the end of list and didn't find a match
                return OptionalInt.empty();

            current = current.next;
        }// end while

        return OptionalInt.of(current.data);
    }

    public OptionalInt delete(int value){

        if(isEmpty())
            throw new LinkedListEmptyException(LINKED_LIST_EMPTY_MESSAGE);

        if(count == 1 && head.data == value){// if only one element, adjust head and tail
            head = null;
            tail = null;
            count--;
            return OptionalInt.of(value);
        }

        Link previous = head;
        Link current = head.next;

        while (current.data != value ){

            if(current.next == null)// not found
                return OptionalInt.empty();

            previous = current;
            current = current.next;

        }// end while

        Link temp = current;
        previous.next = current.next;// move previous's next beyond the current node
        temp.next = null;
        count--;

        return OptionalInt.of(value);
    }

    public void insertLast(int value){

        Link link = new Link(value, null);
        if(isEmpty()){
            head = link;
        }else {
            Link current = head;
            while (current.next!= null)
                current = current.next;

            current.next = link;
        }// end if-else

        tail = link;
        count++;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int getCount() {
        return count;
    }

    public void reverse(){

        if(isEmpty() || count == 1)// nothing to do if list is empty or has just one element
            return;

        Link prev = null;
        Link current = head;
        Link next = head.next;
        tail = head;// reset tail to start of list

        while (next != null){// exit loop if next is beyond last element and set the last element outside the loop
            current.next = prev;

            prev = current;
            current = next;
            next = next.next;
        }// end while

        // adjust next of the last element
        current.next = prev;
        head = current;
    }

    public void display() {
        Link current = head;
        var sj = new StringJoiner(", ", "[ ", " ]");
        while (current != null) {
            sj.add(String.valueOf(current.data));
            current = current.next;
        }// end while
        System.out.println(sj);
    }



}
