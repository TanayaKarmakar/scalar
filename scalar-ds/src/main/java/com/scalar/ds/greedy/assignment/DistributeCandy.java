package com.scalar.ds.greedy.assignment;

import java.util.PriorityQueue;

/**
 * @author t0k02w6 on 14/07/22
 * @project scalar
 */
public class DistributeCandy {
    private static int candy(int[] A) {
        int n = A.length;
        int[] candies = new int[n];

        candies[0] = 1;
        for(int i = 1; i < n; i++) {
            if(A[i] > A[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            } else {
                candies[i] = 1;
            }
        }

        for(int i = n - 2; i >= 0; i--) {
            if(A[i] > A[i + 1] && candies[i] <= candies[i + 1]) {
                candies[i] = candies[i + 1] + 1;
            }
        }

        int totalCandies = 0;
        for(int i = 0; i < n; i++) {
            totalCandies += candies[i];
        }
        return totalCandies;
    }

    public static void main(String[] args) {

        int[] nums = {1,5,2,1};

        System.out.println(candy(nums));

    }
}
