package com.scalar.searching.homework;

/**
 * @author t0k02w6 on 08/05/22
 * @project scalar-ds
 */
public class AllocateBooks {
    private static int books(int[] A, int B) {
        if(B > A.length)
            return -1;
        long max = Integer.MIN_VALUE;
        long total = 0;

        for(int i = 0; i < A.length; i++) {
            max = Long.max(max, A[i]);
            total += A[i];
        }

        long low = max;
        long high = total;

        long res = 0;
        while(low <= high) {
            long mid = (low + high) >> 1;
            if(isValidDistribution(A, B, mid)) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res == 0 ? -1: (int)res;
    }

    private static boolean isValidDistribution(int[] a, int b, long mid) {
        long sum = 0;
        int count = 1;
        for(int i = 0; i < a.length; i++) {
            if(sum + a[i] > mid) {
                count++;
                sum = a[i];
            } else {
                sum += a[i];
            }
        }
        return count <= b;
    }

    public static void main(String[] args) {
        int[] nums = {12, 34, 67, 90};
        int b = 2;

        int ans = books(nums, b);

        System.out.println(ans);

        nums = new int[] {31, 14, 19, 75};
        b = 12;
        ans = books(nums, b);
        System.out.println(ans);
    }
}
