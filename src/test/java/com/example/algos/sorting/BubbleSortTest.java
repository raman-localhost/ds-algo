package com.example.algos.sorting;

import com.example.utils.DataUtils;
import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.OptionalInt;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {

    private int[] data;

    @BeforeEach
    public void setUp() {
        data = DataUtils.generateRandomArray();
    }

    @AfterEach
    public void tearDown() {
        data = null;
    }

    @Test
    void shouldSortGivenArrayOfIntegers() {

        OptionalInt min = Arrays.stream(data).min();
        OptionalInt max = Arrays.stream(data).max();

        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(data);

        assertEquals(min.getAsInt(), data[0]);
        assertEquals(max.getAsInt(), data[data.length - 1]);

    }


}