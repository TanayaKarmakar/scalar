package com.scalar.arrays.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author t0k02w6 on 21/01/22
 * @project scalar-ds
 */
public class AlternatingSubarraysEasy {
    private static int[] solve(int[] A, int B) {
        List<Integer> res = new ArrayList<>();
        int len = (2 * B + 1);
        for(int i = 0; i <= A.length - len; i++) {
            int end = (i + len);
            boolean isAlternating = true;
            int val = A[i];
            for(int j = i + 1; j < end; j++) {
                if(A[j] != 1 - val) {
                    isAlternating = false;
                    break;
                }
                val = 1 - val;
            }
            if(isAlternating) {
                int mid = (end + i - 1)/2;
                res.add(mid);
            }
        }

        int[] finalRes = new int[res.size()];
        for(int i = 0; i < res.size(); i++) {
            finalRes[i] = res.get(i);
        }
        return finalRes;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 0, 1};
        int B = 1;
        int[] finalRes = solve(nums, B);

        System.out.println(Arrays.toString(finalRes));
    }
}
