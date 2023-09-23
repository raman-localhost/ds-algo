package com.example.algos.sorting;

import com.example.utils.DataUtils;

public class SelectionSort {

    public void sort(int[] data) {
        int len = data.length;

        int minIdx;
        for (int i = 0; i < len; i++) {
            minIdx = i;
            for (int j = i + 1; j < len ; j++) {
                // get the index of the smallest element
                if(data[j] < data[minIdx])
                    minIdx = j;

            }// end inner for

            // only swap if minimum element index and i are different
            //otherwise element is already in correct place
            if(minIdx != i)
                DataUtils.swap(data, minIdx, i);
        }// end outer for

    }

}
