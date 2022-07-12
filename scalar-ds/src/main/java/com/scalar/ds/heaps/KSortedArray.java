package com.scalar.ds.heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author t0k02w6 on 10/07/22
 * @project scalar
 */
public class KSortedArray {
    private static int[] solve(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n];
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        for(int i = 0; i <= k; i++) {
            pQ.add(nums[i]);
        }

        int j = 0;
        for(int i = k + 1; i < n; i++) {
            res[j++] = pQ.poll();
            pQ.add(nums[i]);
        }

        while(!pQ.isEmpty()) {
            res[j++] = pQ.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {8,3,7,6,1,5,10,4,9};
        int k = 5;

        int[] res = solve(nums, k);

        System.out.println(Arrays.toString(res));
    }
}
