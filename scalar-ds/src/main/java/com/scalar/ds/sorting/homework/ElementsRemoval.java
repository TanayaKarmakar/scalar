package com.scalar.ds.sorting.homework;

import java.util.Arrays;

/**
 * @author t0k02w6 on 07/02/22
 * @project scalar-ds
 */
public class ElementsRemoval {
    private static int solve(int[] A) {
        Arrays.sort(A);

        int totalCost = 0;
        int k = 1;
        for(int i = A.length - 1; i >= 0; i--) {
            totalCost += k * A[i];
            k++;
        }

        return totalCost;
    }

    public static void main(String[] args) {
        int[] nums = {2,1};

        int totalCost = solve(nums);

        System.out.println(totalCost);
    }
}
