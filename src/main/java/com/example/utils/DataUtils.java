package com.example.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class DataUtils {

    /***
     *
     * @return an array of postive integers
     */
    public static int[] generateRandomArray() {
        return new Random().ints(10, 1, 100).toArray();
    }

    public static List<Integer> generateRandomList(){
        return new Random().ints(10, 1, 100)
                .boxed().collect(Collectors.toCollection(ArrayList::new));
    }

    /***
     *
     * @return an array of fixed elements for searching
     */
    public static int[] generateFixedValuesArray() {
        return new int[]{16, 7, 5, 19, 28, 14, 9, 6, 20, 11};
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
