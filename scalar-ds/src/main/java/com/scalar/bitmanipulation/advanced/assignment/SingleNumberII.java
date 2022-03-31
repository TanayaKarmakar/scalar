package com.scalar.bitmanipulation.advanced.assignment;

/**
 * @author t0k02w6 on 30/03/22
 * @project scalar
 */
public class SingleNumberII {
    private static int singleNumber(final int[] A) {
        int res = 0;

        for(int i = 0; i < 32; i++) {
            int count = 0;
            int mask = (1 << i);
            for(int j = 0; j < A.length; j++) {
                if((A[j] & mask) != 0)
                    count++;
            }
            if(count % 3 == 1) {
                res = res + (1 << i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,4,3,1,5,1,5,3};

        int ans = singleNumber(nums);

        System.out.println(ans);
    }
}
