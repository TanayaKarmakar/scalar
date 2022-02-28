package com.scalar.contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author t0k02w6 on 28/02/22
 * @project scalar-ds
 */
public class AlternatingSubarray {
    private static int[] solve(final int[] A, final int B) {
        List<Integer> indices = new ArrayList<>();

        int len = (2 * B + 1);
        for(int i = 0; i <= (A.length - len); i++) {
            int start = i;
            int end = (i + len - 1);

            boolean isAlternating = true;
            int val = A[i];
            for(int j = start + 1; j <= end; j++) {
                if(A[j] != 1 - val) {
                    isAlternating = false;
                    break;
                }
                val = A[j];
            }

            if(isAlternating) {
                indices.add((start + end) >> 1);
            }
        }

        int[] finalAns = new int[indices.size()];
        int k = 0;
        for(Integer el: indices) {
            finalAns[k++] = el;
        }

        return finalAns;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,1,0,1};
        int B = 1;

        System.out.println(Arrays.toString(solve(nums, B)));
    }
}
