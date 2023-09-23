package com.example.utils;

import java.util.Random;

public class DataUtils {

    /***
     *
     * @return returns an array of postive integers
     */
    public static int[] generateRandomArray() {
        return new Random().ints(10, 1, 100).toArray();
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
