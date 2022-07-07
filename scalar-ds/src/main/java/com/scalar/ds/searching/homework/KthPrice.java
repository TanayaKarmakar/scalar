package com.scalar.ds.searching.homework;

/**
 * @author t0k02w6 on 13/05/22
 * @project scalar
 */
public class KthPrice {
    private static int solve(final int[] A, int B) {
        int min = A[0];
        int max = A[0];

        int n = A.length;
        for (int i = 1; i < n; i++) {
            min = Integer.min(min, A[i]);
            max = Integer.max(max, A[i]);
        }

        int low = min;
        int high = max;
        int ans = 0;

        while(low <= high) {
            int mid = (low + high) >> 1;
            int count = 0;
            for(int i = 0; i < n; i++) {
                if(A[i] <= mid)
                    count++;
            }
            if(count >= B) {
                if(count == B)
                    ans = mid;
                high = mid - 1;
            }
            else {
//                if(count == B)
//                    ans = mid;
                low = mid + 1;
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2,1,4,3,2};
        int k = 3;

        int ans = solve(nums, k);

        System.out.println(ans);

        nums = new int[] {8, 16, 80, 55, 32, 8, 38, 40, 65, 18, 15, 45, 50, 38, 54, 52,
                23, 74, 81, 42, 28, 16, 66, 35, 91, 36, 44, 9, 85, 58, 59, 49, 75, 20, 87,
                60, 17, 11, 39, 62, 20, 17, 46, 26, 81, 92};

        k = 9;

        ans = solve(nums, k);

        System.out.println(ans);

        nums = new int[] {74, 90, 85, 58, 69, 77, 90, 85, 18, 36};
        k = 1;
        ans = solve(nums, k);
        System.out.println(ans);

    }
}
