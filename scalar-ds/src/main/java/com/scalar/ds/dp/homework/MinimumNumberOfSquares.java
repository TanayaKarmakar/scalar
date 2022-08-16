package com.scalar.ds.dp.homework;

/**
 * @author t0k02w6 on 31/07/22
 * @project scalar
 */
public class MinimumNumberOfSquares {
    private static int countMinSquares(int A) {
        int[] dp = new int[A + 1];
        dp[1] = 1;

        for(int i = 2; i <= A; i++) {
            int sqrt = (int)Math.sqrt(i);
            if(sqrt * sqrt == i)
                dp[i] = 1;
            else {
                int minValue = Integer.MAX_VALUE;
                for(int j = 1; j <= sqrt; j++) {
                    minValue = Integer.min(minValue, dp[i - (j * j)]);
                }
                dp[i]= minValue + 1;
            }

        }
        return dp[A];
    }

    public static void main(String[] args) {
        int a = 97280;
        int ans = countMinSquares(a);

        System.out.println(ans);
    }
}
