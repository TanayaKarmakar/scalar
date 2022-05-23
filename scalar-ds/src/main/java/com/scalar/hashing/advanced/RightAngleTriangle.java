package com.scalar.hashing.advanced;

import java.util.*;

/**
 * @author t0k02w6 on 19/05/22
 * @project scalar
 */

public class RightAngleTriangle {
    static class PointPair {
        private int x;
        private int y;

        public PointPair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PointPair pointPair = (PointPair) o;
            return getX() == pointPair.getX() && getY() == pointPair.getY();
        }

        @Override
        public int hashCode() {
            return Objects.hash(getX(), getY());
        }
    }

    private static boolean isPossible(int[][] points) {
        int parellelToX = 0;
        int parallelToY = 0;
        int x1 = points[0][0];
        int y1 = points[0][1];
        int x2 = points[1][0];
        int y2 = points[1][1];
        int x3 = points[2][0];
        int y3 = points[2][1];

        int[] p1 = null;
        int[] p2 = null;
        int[] p3 = null;
        if(x1 == x2 || x1 == x3 || x2 == x3)  {
            parallelToY++;
            if(x1 == x2) {
                p1 = new int[]{x1, y1};
                p2 = new int[]{x2, y2};
                p3 = new int[]{x3, y3};
            }
            if(x1 == x3) {
                p1 = new int[] {x1, y1};
                p2 = new int[] {x3, y3};
                p3 = new int[] {x2, y2};
            }
            if(x2 == x3) {
                p1 = new int[] {x2, y2};
                p2 = new int[] {x3, y3};
                p3 = new int[] {x1, y1};
            }
        }

        if(y1 == y2 || y1 == y3 || y2 == y3)
            parellelToX++;
        if(parellelToX == 0 || parallelToY == 0)
            return false;
        return true;
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{{1,8},{1,4},{5,4}};

        System.out.println(isPossible(points));

        points = new int[][]{{1,8},{1,4},{5,8}};

        System.out.println(isPossible(points));
    }
}
