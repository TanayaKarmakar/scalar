package com.scalar.ds.subsetsubseq.homework;

/**
 * @author t0k02w6 on 03/03/22
 * @project scalar
 */
public class OddEvenSubsequences {
    private static int solve(int[] A) {
        int n = A.length;
        long totalVal = (long)Math.pow(2, n);

        int maxlen = 0;
        for(int i = 0; i < totalVal; i++) {
            int temp = i;
            int type = -1; // 0 - even, 1 - odd
            int j = 0;
            boolean isOddEven = true;
            int count = 0;
            while(temp != 0) {
                if((temp & 1) == 1) {
                    if(type == -1) {
                        if(A[j] % 2 == 0) {
                            type = 0;
                        } else {
                            type = 1;
                        }
                    } else {
                        if((type == 0 && A[j] % 2 == 0) ||
                                (type == 1 && A[j] % 2 != 0)) {
                            isOddEven = false;
                            break;
                        }
                        type = 1 - type;
                    }
                    count++;
                }
                temp = temp >> 1;
                j++;
            }
            if(isOddEven) {
                maxlen = Integer.max(maxlen, count);
            }
        }
        return maxlen;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 5, 6};

        int ans = solve(nums);

        System.out.println(ans);
    }
}
