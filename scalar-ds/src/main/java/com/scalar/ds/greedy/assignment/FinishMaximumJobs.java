package com.scalar.ds.greedy.assignment;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author t0k02w6 on 14/07/22
 * @project scalar
 */
public class FinishMaximumJobs {
    static class Item {
        int start;
        int finish;

        public Item(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }
    }

    static class StartComparator implements Comparator<Item> {

        @Override
        public int compare(Item o1, Item o2) {
            if(o1.start == o2.start)
                return o1.finish - o2.finish;
            return o1.start - o2.start;
        }
    }

    static class FinishComparator implements Comparator<Item> {
        @Override
        public int compare(Item o1, Item o2) {
            return o1.finish - o2.finish;
        }
    }

    private static int solve(int[] A, int[] B) {
        int n = A.length;
        Item[] items = new Item[n];
        for(int i = 0; i < n; i++) {
            items[i] = new Item(A[i], B[i]);
        }
        Arrays.sort(items, new FinishComparator());

        int start = items[0].start;
        int end = items[0].finish;

        int count = 1;

        for(int i = 1; i < items.length; i++) {
            if(items[i].start >= end) {
                count++;
                start = items[i].start;
                end = items[i].finish;
            }
        }
        return count;

//        Arrays.sort(items, new StartComparator());
//
//        PriorityQueue<Item> pQ = new PriorityQueue<>(new FinishComparator());
//        for(int i = 0; i < n; i++) {
//            if(pQ.isEmpty())
//                pQ.add(items[i]);
//            else {
//                if(items[i].start >= pQ.peek().finish) {
//                    pQ.add(items[i]);
//                }
//            }
//        }
//        return pQ.size();
    }

    public static void main(String[] args) {
        int[] start = {1,5,7,1};
        int[] finish = {7,8,8,8};

        int ans = solve(start, finish);

        System.out.println(ans);
    }
}
