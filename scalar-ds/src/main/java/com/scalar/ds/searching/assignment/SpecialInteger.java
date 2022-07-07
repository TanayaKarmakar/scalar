package com.scalar.ds.searching.assignment;

/**
 * @author t0k02w6 on 06/05/22
 * @project scalar
 */
public class SpecialInteger {
    private static boolean isSubarrayValid(int[] A, int size, int B) {
        long sum = 0;
        int l = 0;
        int r = 0;
        for(r = 0; r < size; r++) {
            sum += A[r];
        }

        //r = r - 1;
        while(r < A.length) {
            if(sum > B)
                return false;
            sum += A[r];
            r++;
            sum -= A[l];
            l++;
        }
        if(sum > B)
            return false;
        return true;
    }

    private static int solve(int[] A, int B) {
        int start = 1;
        int end = A.length;

        int len = 0;

        while(start <= end) {
            int mid = (start + end) >> 1;
            if(isSubarrayValid(A, mid, B)) {
                len = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int B = 10;

        int ans = solve(nums, B);

        System.out.println(ans);

        nums = new int[] {5, 17, 100, 11};
        B = 130;

        ans = solve(nums, B);

        System.out.println(ans);
    }
}
