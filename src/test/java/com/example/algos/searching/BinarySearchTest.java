package com.example.algos.searching;

import com.example.utils.DataUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {


    private List<Integer> data;
    private final int value = 150;

    @BeforeEach
    public void setUp() {
        data = DataUtils.generateRandomList();
        data.add(value);
        Collections.sort(data);
    }

    @AfterEach
    public void tearDown() {
        data = null;
    }

    @Test
    void shouldReturnIndexOfGivenElement() {
        var binarySearch = new BinarySearch();
        int index = binarySearch.search(data, value);

        int expectedIndex = data.indexOf(value);

        assertEquals(expectedIndex, index);
    }

    @Test
    void shouldReturnNegativeOneAsIndexForElementNotFound() {
        var binarySearch = new BinarySearch();
        int value = 500;
        int index = binarySearch.search(data, value);

        int expectedIndex = -1;

        assertEquals(expectedIndex, index);
    }

}