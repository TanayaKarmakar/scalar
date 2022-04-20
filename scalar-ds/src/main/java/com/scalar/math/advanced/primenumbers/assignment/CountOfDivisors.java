package com.scalar.math.advanced.primenumbers.assignment;

import java.util.Arrays;

/**
 * @author t0k02w6 on 09/04/22
 * @project scalar
 */
public class CountOfDivisors {
    private static int[] solve(int[] A) {
        int max = Integer.MIN_VALUE;
        for(Integer el: A) {
            max = Integer.max(max, el);
        }


        int[] spf = new int[max + 1];
        //spf[1] = 1;
        for(int i = 2; i <= max; i++) {
            if(spf[i] == 0) {
                spf[i] = i;
                int j = i;
                while((i * j) <= max) {
                    if(spf[i * j] == 0) {
                        spf[i * j] = i;
                    }
                    j++;
                }
            }
        }

        int[] result = new int[A.length];

        for(int i = 0; i < A.length; i++) {
            result[i] = countOfDivisors(spf, A[i]);
        }
        return result;
    }

    private static int countOfDivisors(int[] spf, int n) {
        int temp = n;
        int count = 2;
        while(spf[temp] != temp) {
            count++;
            temp = temp/spf[temp];
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,4,5};

        int[] ans = solve(nums);

        System.out.println(Arrays.toString(ans));

        nums = new int[] {8,9,10};
        ans = solve(nums);

        System.out.println(Arrays.toString(ans));
    }
}
