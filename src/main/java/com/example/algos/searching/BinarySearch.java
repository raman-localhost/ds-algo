package com.example.algos.searching;

import java.util.List;

public class BinarySearch {

    public int search(List<Integer> data, int value){

        int low= 0,  high = data.size() - 1;
        int middle;

        while (low <= high){
            middle = (low + high) / 2 ;

            if(data.get(middle).equals(value)){
                return middle;
            } else if (data.get(middle) > value) {
                high = middle - 1;
            }else {
                low = middle + 1;
            }// end if-else
        }// end while

     return -1;
    }

}
