package com.example.ds;

import com.example.ds.exceptions.LinkedListEmptyException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.OptionalInt;
import java.util.Random;

import static com.example.ds.exceptions.LinkedListEmptyException.LINKED_LIST_EMPTY_MESSAGE;
import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    private LinkedList linkedList;
    private  int value;
    private int count;

    @BeforeEach
    void setup(){
        linkedList = new LinkedList();
        count = 5;
        value = 500;
    }

    @AfterEach
    void teardown(){
        linkedList = null;
    }

    @Test
    void insertFirstShouldAddElementToFrontOfEmptyList() {
        linkedList.insertFirst(value);

        assertEquals(value, linkedList.peekFirst());
    }

    @Test
    void insertFirstShouldAddNElementsToFrontOfEmptyList() {

        fillList(count);
        assertEquals(count, linkedList.getCount());
    }

    private void fillList(int count) {
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            linkedList.insertFirst(random.nextInt(100));
        }
    }


    @Test
    void deleteFirstShouldRemoveFirstElementFromList() {

        fillList(count);

        linkedList.insertFirst(value);

        int first = linkedList.deleteFirst();
        assertEquals(value, first);
    }

    @Test
    void deleteFirstShouldThrowLinkedListFullExceptionUponRemovingFromEmptyList() {
        var linkedListEmptyException = assertThrows(LinkedListEmptyException.class, () -> linkedList.deleteFirst());
        assertEquals(LINKED_LIST_EMPTY_MESSAGE, linkedListEmptyException.getMessage());
    }

    @Test
    void findShouldReturnElementFoundInList() {

        fillList(count);

        linkedList.insertFirst(value);
        assertEquals(value, linkedList.find(value).getAsInt());
    }

    @Test
    void findShouldReturnEmptyOptionalIntForElementNotFoundInList() {

        fillList(count);

        OptionalInt optionalInt = linkedList.find(value);
        assertEquals(OptionalInt.empty(), optionalInt);
    }

    @Test
    void insertLastShouldAddElementToEndOfList() {
        linkedList.insertLast(value);
        assertEquals(value, linkedList.peekLast());
    }


    @Test
    void deleteShouldRemoveGivenElementFromList(){

        fillList(count);
        linkedList.insertLast(value);

        OptionalInt optionalInt = linkedList.delete(value);
        if(optionalInt.isPresent()){
            assertEquals(value, optionalInt.getAsInt());
        }else {
            fail("expected = " + value+ ",  received = " + optionalInt);
        }// end if-else
    }

    @Test
    void deleteShouldThrowLinkedListEmptyExceptionUponRemovingFromEmptyList(){
        var linkedListEmptyException = assertThrows(LinkedListEmptyException.class, () -> linkedList.delete(value));
        assertEquals(LINKED_LIST_EMPTY_MESSAGE, linkedListEmptyException.getMessage());
    }

    @Test
    void reverseShouldReverseTheListInPlace() {
        fillList(count);

        int first = linkedList.peekFirst();
        int last = linkedList.peekLast();

        linkedList.reverse();

        assertEquals(first, linkedList.peekLast());
        assertEquals(last, linkedList.peekFirst());
    }

}