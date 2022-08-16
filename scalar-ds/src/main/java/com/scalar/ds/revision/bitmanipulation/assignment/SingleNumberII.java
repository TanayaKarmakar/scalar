package com.scalar.ds.revision.bitmanipulation.assignment;

/**
 * @author t0k02w6 on 10/08/22
 * @project scalar
 */
public class SingleNumberII {
    private static int singleNumber(final int[] A) {
        int result = 0;
        for(int i = 31; i >= 0; i--) {
            int setBitCount = 0;
            for(int j = 0; j < A.length; j++) {
                if(((A[j] >> i) & 1) == 1) {
                    setBitCount++;
                }
            }
            result = (result << 1);
            if(setBitCount % 3 != 0)
                result += 1;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 3, 3, 2, 2, 3, 1, 1};
        int ans = singleNumber(nums);

        System.out.println(ans);
    }
}
