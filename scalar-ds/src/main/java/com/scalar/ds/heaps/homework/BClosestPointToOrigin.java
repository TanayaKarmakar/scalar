package com.scalar.ds.heaps.homework;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author t0k02w6 on 07/07/22
 * @project scalar
 */


public class BClosestPointToOrigin {
    static class DistanceComparator implements Comparator<Point> {

        @Override
        public int compare(Point o1, Point o2) {
            if(o1.distFromOrigin == o2.distFromOrigin) {
                if(o1.x == o2.x)
                    return o1.y - o2.y;
                return o1.x - o2.x;
            }
            return o1.distFromOrigin - o2.distFromOrigin;
        }
    }

    static class Point {
        int x;
        int y;
        int distFromOrigin;

        public Point(int x, int y, int distFromOrigin) {
            this.x = x;
            this.y = y;
            this.distFromOrigin = distFromOrigin;
        }
    }

    private static int calcDist(int x, int y) {
        return (x * x) + (y * y);
    }

    private static int[][] solve(int[][] A, int B) {
        PriorityQueue<Point> pQ = new PriorityQueue<>(new DistanceComparator());
        for(int i = 0; i < A.length; i++) {
            int dist = calcDist(A[i][0], A[i][1]);
            Point point = new Point(A[i][0], A[i][1], dist);
            pQ.add(point);
        }

        int[][] result = new int[B][];
        int i = 0;
        while(!pQ.isEmpty() && B > 0) {
            Point point = pQ.poll();
            result[i++] = new int[]{point.x, point.y};
            B--;
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
