package com.scalar.ds.bitmanipulation.advanced.assignment;

/**
 * @author t0k02w6 on 01/04/22
 * @project scalar
 */
public class MaximumSatisfaction {
    private static int solve(int[] A) {
        if(A.length < 4)
            return 0;
        int result = 0;
        int n = A.length;
        for(int i = 31; i >= 0; i--) {
            int count = 0;
            for(int j = 0; j < n; j++) {
                if(A[j] != -1) {
                    if((A[j] & (1 << i)) > 0) {
                        count++;
                    }
                    if(count >= 4)
                        break;
                }
            }

            if(count >= 4) {
                for(int j = 0; j < n; j++) {
                    if(A[j] != -1) {
                        if((A[j] & (1 << i)) == 0) {
                            A[j] = -1;
                        }
                    }
                }
                result = result | (1 << i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {10, 20, 15, 4, 14};
        int ans = solve(nums);

        System.out.println(ans);
    }
}
