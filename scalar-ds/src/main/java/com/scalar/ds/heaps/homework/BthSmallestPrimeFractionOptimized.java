package com.scalar.ds.heaps.homework;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author t0k02w6 on 17/07/22
 * @project scalar
 */
public class BthSmallestPrimeFractionOptimized {
    static class Item implements Comparable<Item> {
        int p;
        int q;
        double fraction;

        public Item(int p, int q, double fraction) {
            this.p = p;
            this.q = q;
            this.fraction = fraction;
        }

        @Override
        public int compareTo(Item o) {
            if(this.fraction == o.fraction)
                return 0;
            else if(this.fraction < o.fraction)
                return 1;
            else
                return -1;
        }
    }

    private static int[] solve(int[] A, int B) {
        int n = A.length;
        LinkedList<Item>[] items = new LinkedList[n - 1];
        PriorityQueue<Item> pQ = new PriorityQueue<>();

        for(int i = 0; i < n - 1; i++) {
            LinkedList<Item> list= new LinkedList<>();
            for(int j = n - 1; j > i; j--) {
                list.add(new Item(A[i], A[j], A[i]/ (double)A[j]) );
            }
            items[i] = list;
            pQ.add(list.get(0));
        }

        int i = 0;
        int listIndx = 1;
        B--;
        while(!pQ.isEmpty() && B > 1) {
            if(i < items.length && pQ.peek().fraction > items[i].get(listIndx).fraction) {
                pQ.poll();
                pQ.add(items[i].get(listIndx));
            }
            if(listIndx + 1 < items[i].size()) {
                listIndx++;
            } else {
                i++;
                if(i < items.length && items[i].size() > 1)
                    listIndx = 1;
            }

            B--;
        }
        return new int[] {pQ.peek().p, pQ.peek().q};
    }

    public static void main(String[] args) {
        int[] nums = {1, 719, 983, 9293, 11321, 14447, 16411, 17881, 22079, 28297};
        int B = 42;

        int[] ans = solve(nums, B);

        System.out.println(Arrays.toString(ans));
    }
}
