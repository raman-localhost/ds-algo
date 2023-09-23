package com.example.algos.sorting;

import com.example.utils.DataUtils;

public class InsertionSort {

    public void sort(int[] data) {
        int len = data.length;

        for (int i = 0; i < len - 1; i++) {

            int j = i + 1; // last index of the partially sorted section

            // if current element is smaller than last sorted element in the partially
            // sorted section, swap them
            while (j > 0 && (data[j] < data[j - 1])) {
                DataUtils.swap(data, j, j - 1);
                j--;
            }// end inner while

        }// end outer for


    }

}
