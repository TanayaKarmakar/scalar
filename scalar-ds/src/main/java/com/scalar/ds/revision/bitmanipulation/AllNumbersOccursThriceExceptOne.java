package com.scalar.ds.revision.bitmanipulation;

/**
 * @author t0k02w6 on 04/08/22
 * @project scalar
 */
public class AllNumbersOccursThriceExceptOne {
    private static int findNum(int[] nums) {
        int result = 0;
        for(int i = 31; i >= 0; i--) {
            int countSetBit = 0;
            for(int j = 0; j < nums.length; j++) {
                int current = nums[j] >> i;
                if((current & 1) == 1)
                    countSetBit++;
            }
            result = (result << 1);
            if(countSetBit % 3 != 0) {
                result += 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,3,5,3,5,3,1,6,5};
        int ans = findNum(nums);

        System.out.println(ans);
    }
}
