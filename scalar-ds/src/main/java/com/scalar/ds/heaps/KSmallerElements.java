package com.scalar.ds.heaps;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author t0k02w6 on 10/07/22
 * @project scalar
 */
public class KSmallerElements {
    private static int[] kSmallerElements(int[] nums, int k) {
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i = 0; i < k; i++) {
            pQ.add(nums[i]);
        }

        for(int i = k; i < nums.length; i++) {
            if(nums[i] < pQ.peek()) {
                pQ.poll();
                pQ.add(nums[i]);
            }
        }

        int[] result = new int[k];
        int j = k - 1;
        while(!pQ.isEmpty()) {
            result[j--] = pQ.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {8,3,10,4,11,2,7,6,5,1};
        int k = 4;
        int[] res = kSmallerElements(nums, k);

        System.out.println(Arrays.toString(res));
    }
}
