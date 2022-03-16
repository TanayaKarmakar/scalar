package com.scalar.subsetsubseq;

import java.util.ArrayList;
import java.util.List;

/**
 * @author t0k02w6 on 02/03/22
 * @project scalar
 */
public class PrintAllSubsets {
    private static void printAllSubset(int[] nums) {
        int n = nums.length;
        int totalVal = (int)Math.pow(2, n);

        for(int i = 0; i < totalVal; i++) {
            int k = i;
            List<Integer> result = new ArrayList<>();
            int j = 0;
            while(k != 0) {
                if((k & 1) == 1) {
                    result.add(nums[j]);
                }
                k = k >> 1;
                j++;
            }
            System.out.println(result);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};

        printAllSubset(nums);
    }
}
