package com.scalar.ds.heaps;

import java.util.PriorityQueue;

/**
 * @author t0k02w6 on 06/07/22
 * @project scalar
 */
public class MinimumCostToConnectAllTheRopes {
    private static int minCost(int[] nums) {
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        for(int i = 0; i < nums.length; i++) {
            pQ.add(nums[i]);
        }

        int total = 0;
        while(pQ.size() > 1) {
            int num1 = pQ.poll();
            int num2 = pQ.poll();
            int res = num1 + num2;
            total += res;
            pQ.add(res);
        }
        return total;
    }

    public static void main(String[] args) {
        int[] nums = {2,5,2,6,3};

        int ans = minCost(nums);

        System.out.println(ans);
    }
}
