package com.scalar.ds.arrays.homework;

import java.util.ArrayList;

/**
 * @author t0k02w6 on 14/01/22
 * @project scalar-ds
 */
public class TimeToEquality {
    private static int solve(ArrayList<Integer> A) {
        int max = Integer.MIN_VALUE;

        for(Integer el: A) {
            max = Integer.max(max, el);
        }

        int totalTime = 0;
        for(Integer el: A) {
            totalTime += (max - el);
        }

        return totalTime;
    }

    public static void main(String[] args) {

    }
}
