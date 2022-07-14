package com.scalar.ds.greedy.assignment;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author t0k02w6 on 14/07/22
 * @project scalar
 */
public class FreeCars {
    static class Item {
        int time;
        int profit;

        public Item(int time, int profit) {
            this.time = time;
            this.profit = profit;
        }
    }

    static class TimeComparator implements Comparator<Item> {

        @Override
        public int compare(Item o1, Item o2) {
            return o1.time - o2.time;
        }
    }

    static class ProfitComparator implements Comparator<Item> {

        @Override
        public int compare(Item o1, Item o2) {
            return o1.profit - o2.profit;
        }
    }

    private static int solve(int[] A, int[] B) {
        int n = A.length;
        Item[] items = new Item[n];

        for(int i = 0; i < n; i++) {
            items[i] = new Item(A[i], B[i]);
        }

        Arrays.sort(items,new TimeComparator());

        PriorityQueue<Item> pQ = new PriorityQueue<>(new ProfitComparator());
        int currentTime = 0;
        for(int i = 0; i < n; i++) {
            if(items[i].time > currentTime) {
                pQ.add(items[i]);
                currentTime++;
            } else {
                if(!pQ.isEmpty() && pQ.peek().profit < items[i].profit) {
                    pQ.poll();
                    pQ.add(items[i]);
                }
            }
        }
        long totalProfit = 0;
        int mod = 1000000007;
        while(!pQ.isEmpty()) {
            totalProfit += pQ.poll().profit;
        }
        return (int)(totalProfit % mod);
    }

    public static void main(String[] args) {
        int[] A = {1,3,2,3,3};
        int[] B = {5,6,1,3,9};
    }
}
