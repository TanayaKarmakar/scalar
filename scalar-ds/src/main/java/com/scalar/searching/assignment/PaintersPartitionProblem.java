package com.scalar.searching.assignment;

/**
 * @author t0k02w6 on 08/05/22
 * @project scalar-ds
 */
public class PaintersPartitionProblem {
    private static int paint(int A, int B, int[] C) {
        int max = Integer.MIN_VALUE;
        int total = 0;
        for(int i = 0; i < C.length; i++) {
            max = Integer.max(max, C[i]);
            total += C[i];
        }
        long low = 1L * max * B;
        long high = 1L * total * B;
        long res = low;
        while(low <= high) {
            long mid = (low + high) >> 1;
            if(isDistPossible(C, mid,B, A)) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (int)(res % 10000003);
    }

    private static boolean isDistPossible(int[] c, long mid, long timeForOneUnit, long numOfLabour) {
        int count = 1;
        long sum = 0;
        for(int i = 0; i < c.length; i++) {
            if(sum + timeForOneUnit * c[i] > mid) {
                sum = timeForOneUnit * c[i];
                count++;
            } else {
                sum += timeForOneUnit * c[i];
            }
        }
        return count <= numOfLabour;
    }

    public static void main(String[] args) {
        int[] nums = {1,8,11,3};
        int A = 10;
        int B = 1;

        int ans = paint(A, B, nums);

        System.out.println(ans);
    }
}
