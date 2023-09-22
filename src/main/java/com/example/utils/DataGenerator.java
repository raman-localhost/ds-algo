package com.example.utils;

import java.util.Random;
import java.util.stream.IntStream;

public class DataGenerator {

    /***
     *
     * @return returns an array of postive integers
     */
    public static int[] generateRandomArray(){
        return new Random().ints(10).toArray();
    }

}
