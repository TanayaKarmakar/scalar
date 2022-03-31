package com.scalar.moduloarithmetic.homework;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author t0k02w6 on 03/02/22
 * @project scalar-ds
 */
public class RepeatingAndMissingNumber {
    private static int[] repeatedNumber(final int[] A) {
        int n = A.length;
        for(int i = 0; i < n; i++) {
            while(A[i] != (i + 1)) {
                int tmp = A[i];
                if(A[tmp - 1] == tmp)
                    break;
                int tmp1 = A[tmp - 1];
                A[i] = tmp1;
                A[tmp - 1] = tmp;
            }
        }

        for(int i = 0; i < n; i++) {
            if(A[i] != (i + 1)) {
                return new int[] {A[i], (i + 1)};
            }
        }
        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 5, 3};

        int[] ans = repeatedNumber(nums);

        System.out.println(Arrays.toString(ans));
    }
}
