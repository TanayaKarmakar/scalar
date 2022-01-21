package com.scalar.arrays.assignment;

/**
 * @author t0k02w6 on 20/01/22
 * @project scalar-ds
 */
public class LeastSubarrayAverage {
    private static int solve(int[] A, int B) {
        int leastSum = Integer.MAX_VALUE;
        int minAvgIndx = -1;
        int firstIndx = -1;
        for(int i = 0; i < A.length; i++) {
            int currentSum = 0;
            for(int j = i; j < A.length; j++) {
                if(j == i) {
                    firstIndx = i;
                }
                currentSum += A[j];
                if(j - i + 1 == B) {
                    if(leastSum > currentSum) {
                        leastSum = currentSum;
                        minAvgIndx = firstIndx;
                    }
                    break;
                }
            }
        }
        return minAvgIndx;
    }

    public static void main(String[] args) {
        int[] nums = {20, 3, 13, 5, 10, 14, 8, 5, 11, 9, 1, 11};
        int B = 9;
        int leastAvg = solve(nums, B);
        System.out.println(leastAvg);
    }
}
