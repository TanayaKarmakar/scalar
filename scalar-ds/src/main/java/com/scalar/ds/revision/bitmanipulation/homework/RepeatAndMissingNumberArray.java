package com.scalar.ds.revision.bitmanipulation.homework;

import java.util.Arrays;

/**
 * @author t0k02w6 on 10/08/22
 * @project scalar
 */
public class RepeatAndMissingNumberArray {
    private static int[] repeatedNumber(final int[] A) {
        int xorAll = 0;
        for(int i = 0; i < A.length; i++) {
            xorAll = xorAll ^ A[i];
        }

        for(int i = 1; i <= A.length; i++) {
            xorAll = xorAll ^ i;
        }

        int k = 0;
        while(((xorAll >> k) & 1) == 0) {
            k++;
        }

        int group1 = 0;
        int group2 = 0;

        for(int i = 0; i < A.length; i++) {
            if(((A[i] >> k) & 1) == 1)
                group1 = group1 ^ A[i];
            else
                group2 = group2 ^ A[i];
        }

        for(int i = 1; i <= A.length; i++) {
            if(((i >> k) & 1) == 1)
                group1 = group1 ^ i;
            else
                group2 = group2 ^ i;
        }
        return new int[] {group1, group2};
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 5, 3};

        int[] ans = repeatedNumber(nums);

        System.out.println(Arrays.toString(ans));
    }
}
