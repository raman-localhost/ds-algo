package com.example.algos.sorting;

import java.util.Arrays;
import static com.example.utils.DataUtils.swap;

public class BubbleSort {

    public void sort(int[] data) {
        int len = data.length;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                // if current element is greater than the next element,
                // swap them and move the greater element to the right
                if (data[j] > data[j + 1])
                    swap(data, j, j + 1);

            }// end inner for
        }// end outer for

    }


}
