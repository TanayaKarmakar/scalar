package com.scalar.ds.sorting.advanced;

import java.util.Arrays;

/**
 * @author t0k02w6 on 27/04/22
 * @project scalar
 */
public class KthLagestElement {
    private static int kthLargest(int[] nums, int k) {
        int n = nums.length;
        int last = n - 1;
        int tempK = k;
        for(int i = 0; i < (n - 1); i++) {
            if(tempK > 0) {
                int maxIndx = 0;
                for(int j = 0; j <= last; j++) {
                    if(nums[j] > nums[maxIndx]) {
                        maxIndx = j;
                    }
                }
                if(last != maxIndx) {
                    int tmp = nums[last];
                    nums[last] = nums[maxIndx];
                    nums[maxIndx] = tmp;
                }
                last--;
                tempK--;
            } else {
                break;
            }
        }
        System.out.println(Arrays.toString(nums));

        return nums[n - k];
    }

    public static void main(String[] args) {
        int[] nums = {5,8,1,3,15,7,2};
        int k = 1;
        int ans = kthLargest(nums, k);

        System.out.println(ans);
    }
}
