package com.scalar.bitmanipulation.homework;

import java.util.Arrays;

/**
 * @author t0k02w6 on 31/03/22
 * @project scalar
 */
public class SingleNumberIII {
    private static int[] solve(int[] A) {
        int n = A.length;
        int xorAll = 0;
        for(int i = 0; i < n; i++) {
            xorAll = xorAll ^ A[i];
        }
        int setBit = 0;
        for(setBit = 0; setBit < 32; setBit++) {
            if((xorAll & (1 << setBit)) > 0)
                break;
        }

        int group1Xor = 0;
        int group2Xor = 0;
        for(int i = 0; i < n; i++) {
            if((A[i] & (1 << setBit)) > 0) {
                group1Xor = group1Xor ^ A[i];
            } else {
                group2Xor = group2Xor ^ A[i];
            }
        }
        return new int[] {Integer.min(group1Xor, group2Xor), Integer.max(group1Xor, group2Xor)};
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 2, 4};
        int[] ans = solve(nums);

        System.out.println(Arrays.toString(ans));
    }
}
