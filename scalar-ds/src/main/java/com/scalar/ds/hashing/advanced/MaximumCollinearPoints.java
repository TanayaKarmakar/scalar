package com.scalar.ds.hashing.advanced;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author t0k02w6 on 15/05/22
 * @project scalar
 */
class PointPair {
    private int m;
    private int c;

    public PointPair(int m, int c) {
        this.m = m;
        this.c = c;
    }

    public int getM() {
        return m;
    }

    public int getC() {
        return c;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PointPair pointPair = (PointPair) o;
        return getM() == pointPair.getM() && getC() == pointPair.getC();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getM(), getC());
    }
}

public class MaximumCollinearPoints {
    private static int maxCollinearPointsCount(int[][] points) {
        Map<PointPair, Integer> map = new HashMap<>();
        boolean[] visited = new boolean[points.length];

        int maxVal = 0;
        for(int i = 0; i < points.length -1; i++) {
            for(int j = i + 1; j < points.length; j++) {
                if(!visited[j]) {
                    int x1 = points[i][0];
                    int y1 = points[i][1];
                    int x2 = points[j][0];
                    int y2 = points[j][1];

                    if(x2 != x1) {
                        int m = (y2 - y1) / (x2 - x1);
                        int c = ((y1 * x2) - (y2 * x1)) / (x2 - x1);
                        PointPair pointPair = new PointPair(m,c);
                        map.put(pointPair, map.getOrDefault(pointPair, 1) + 1);
                        maxVal = Integer.max(maxVal, map.get(pointPair));
                        visited[j] = true;
                    }
                }
            }
        }
        return maxVal;
    }

    public static void main(String[] args) {
        int[][] points = {{1,1},{2,2},{3,3},{5,5},{3,1},{5,2}};

        int ans = maxCollinearPointsCount(points);

        System.out.println(ans);
    }
}
