package com.scalar.ds.heaps.homework;

import java.util.PriorityQueue;

/**
 * @author t0k02w6 on 07/07/22
 * @project scalar
 */
public class MishaAndCandies {
    static class Box implements Comparable<Box> {
        int numChocolate;
        boolean alreadySelected;

        public Box(int numChocolate, boolean alreadySelected) {
            this.numChocolate = numChocolate;
            this.alreadySelected = alreadySelected;
        }

        @Override
        public int compareTo(Box o) {
            return this.numChocolate - o.numChocolate;
        }
    }

    private static int solve(int[] A, int B) {
        PriorityQueue<Box> pQ = new PriorityQueue<>();
        for(int i = 0; i < A.length; i++) {
            Box box = new Box(A[i], false);
            pQ.add(box);
        }

        int totalCandies = 0;
        while(!pQ.isEmpty()) {
            Box box = pQ.poll();
            if(box.alreadySelected)
                continue;
            if(box.numChocolate > B)
                break;
            int el = box.numChocolate;
            totalCandies += (el / 2);
            if(pQ.isEmpty())
                continue;
            Box next = pQ.poll();

            int remaining = el - (el / 2);
            next.numChocolate = next.numChocolate + remaining;
            pQ.add(next);
        }

        return totalCandies;
    }

    public static void main(String[] args) {
        int[] boxes = {705};
        int B = 895;

        int ans = solve(boxes, B);
        System.out.println(ans);

    }
}
