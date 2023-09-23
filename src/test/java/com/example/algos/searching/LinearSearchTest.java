package com.example.algos.searching;

import com.example.algos.sorting.InsertionSort;
import com.example.utils.DataUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.xml.crypto.Data;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class LinearSearchTest {

    private List<Integer> data;
    private int value = 150;

    @BeforeEach
    public void setUp() {
        data = DataUtils.generateRandomList();
        data.add(value);
        Collections.shuffle(data);
    }

    @AfterEach
    public void tearDown() {
        data = null;
    }

    @Test
    void shouldSortGivenArrayOfIntegers() {
        LinearSearch linearSearch = new LinearSearch();
        int index = linearSearch.search(data, value);

        int expectedIndex = data.indexOf(value);

        assertEquals(expectedIndex, index);
    }
}