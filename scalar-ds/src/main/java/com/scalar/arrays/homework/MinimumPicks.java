package com.scalar.arrays.homework;

import java.util.ArrayList;

/**
 * @author t0k02w6 on 12/01/22
 * @project scalar-ds
 */
public class MinimumPicks {
    private static int solve(ArrayList<Integer> A) {
        int maxEven = Integer.MIN_VALUE;
        int minOdd = Integer.MAX_VALUE;

        for(Integer el: A) {
            if(el % 2 == 0) {
                maxEven = Integer.max(maxEven, el);
            } else {
                minOdd = Integer.min(minOdd, el);
            }
        }
        return (maxEven - minOdd);
    }

    public static void main(String[] args) {

    }
}
