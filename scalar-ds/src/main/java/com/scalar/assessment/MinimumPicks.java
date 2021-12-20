package com.scalar.assessment;

/**
 * @author t0k02w6 on 19/12/21
 * @project scalar-ds
 */
public class MinimumPicks {
    private static int solve(int[] A) {
        int maxEvenNum = Integer.MIN_VALUE;
        int minOddNum = Integer.MAX_VALUE;


        for(int i = 0; i < A.length; i++) {
            if(A[i] % 2 == 0) {
                if(maxEvenNum < A[i]) {
                    maxEvenNum = A[i];
                }
            } else {
                if(minOddNum > A[i]) {
                    minOddNum = A[i];
                }
            }
        }


        return maxEvenNum - minOddNum;

    }

    public static void main(String[] args) {
        int[] arr = {0,2,9};

        int ans = solve(arr);
        System.out.println(ans);

        arr = new int[]{-98,54,-52,15,23,-97,12,-64,52,85};
        ans = solve(arr);
        System.out.println(ans);
    }
}
