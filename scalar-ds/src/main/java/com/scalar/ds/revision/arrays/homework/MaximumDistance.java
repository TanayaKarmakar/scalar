package com.scalar.ds.revision.arrays.homework;

import java.util.Arrays;

/**
 * @author t0k02w6 on 31/07/22
 * @project scalar
 */
public class MaximumDistance {
    static class Item implements Comparable<Item>{
        int num;
        int indx;

        public Item(int num, int indx) {
            this.num = num;
            this.indx = indx;
        }

        @Override
        public int compareTo(Item o) {
            return this.num - o.num;
        }
    }

    private static int maximumGap(final int[] A) {
        int n = A.length;
        Item[] items = new Item[n];

        for(int i = 0; i < n; i++) {
            items[i] = new Item(A[i], i);
        }
        Arrays.sort(items);

        int maxIndx = items[n - 1].indx;
        int maxAns = 0;

        for(int i = n - 2; i >= 0; i--) {
            maxAns = Integer.max(maxAns, maxIndx - items[i].indx);
            maxIndx = Integer.max(maxIndx, items[i].indx);
        }

        return maxAns;
    }

    public static void main(String[] args) {
        int[] nums = {3,5,4,2};
        int ans = maximumGap(nums);

        System.out.println(ans);
    }
}
