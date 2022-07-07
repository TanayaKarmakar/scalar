package com.scalar.ds.twopointers.homework;

import java.util.Arrays;

/**
 * @author t0k02w6 on 12/05/22
 * @project scalar
 */
public class ThreeSumClosest {
    private static int threeSumClosest(int[] A, int B) {
        Arrays.sort(A);

        int n = A.length;
        int minDiff = Integer.MAX_VALUE;
        int closestSum = 0;

        for(int i = 0; i < n - 2; i++) {
            int start = i + 1;
            int end = n - 1;
            while(start < end) {
                int sum = A[i] + A[start] + A[end];
                if(sum == B)
                    return sum;
                else {
                    int diff = Math.abs(B - sum);
                    if(diff < minDiff) {
                        minDiff = diff;
                        closestSum = sum;
                    }
                    if(sum < B)
                        start++;
                    else
                        end--;
                }
            }
        }
        return closestSum;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int B = 1;

        int ans =  threeSumClosest(nums, B);

        System.out.println(ans);
    }
}
