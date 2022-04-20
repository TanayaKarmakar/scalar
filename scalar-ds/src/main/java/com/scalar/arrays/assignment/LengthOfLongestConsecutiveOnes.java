package com.scalar.arrays.assignment;

/**
 * @author t0k02w6 on 31/03/22
 * @project scalar
 */
public class LengthOfLongestConsecutiveOnes {
    private static int solve(String A) {
        char[] chars = A.toCharArray();

        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;
        boolean oneZeroFound = false;
        for(int i = 0; i < chars.length; i++) {
            if(chars[i] == '1')
                currentSum++;
            else {
                if(!oneZeroFound) {
                    currentSum++;
                    oneZeroFound = true;
                } else {
                    maxSum = Integer.max(maxSum, currentSum);
                    currentSum = 0;
                    oneZeroFound = false;
                }
            }

            maxSum = Integer.max(maxSum, currentSum);
            if(currentSum < 0) {
                oneZeroFound = false;
                currentSum = 0;
            }

        }
        return maxSum == Integer.MIN_VALUE ? 0: maxSum;
    }

    public static void main(String[] args) {
        String str = "111000";
        int ans = solve(str);

        System.out.println(ans);

        str = "111011101";

        ans = solve(str);

        System.out.println(ans);
    }
}
