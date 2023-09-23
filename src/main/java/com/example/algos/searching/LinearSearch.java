package com.example.algos.searching;

import java.util.List;

public class LinearSearch {

    public int search(List<Integer> data, int value) {

        int len = data.size();

        for (int i = 0; i < len; i++) {
            if (data.get(i).equals(value))
                return i;
        }// end for

        return -1;
    }

}
