package com.scalar.ds.sorting.advanced.homework;

import com.scalar.ds.common.QueryTriplet;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author t0k02w6 on 30/04/22
 * @project scalar
 */
class DistanceComparator implements Comparator<QueryTriplet<Integer, Integer, Integer>> {

    @Override
    public int compare(QueryTriplet<Integer, Integer, Integer> o1, QueryTriplet<Integer, Integer, Integer> o2) {
        return o2.getThird() - o1.getThird();
    }
}

public class BClosestPointsToOrigin {
    private static int dist(int[] point) {
        return (point[0] * point[0]) + (point[1] * point[1]);
    }

    private static int[][] solve(int[][] A, int B) {
        //List<QueryTriplet<Integer, Integer, Integer>> list = new ArrayList<>();
        PriorityQueue<QueryTriplet<Integer, Integer, Integer>> pQ = new PriorityQueue<>(new DistanceComparator());
        for(int i = 0; i < B; i++) {
            int first = A[i][0];
            int second = A[i][1];
            int third = dist(A[i]);
            QueryTriplet<Integer, Integer, Integer> qt = new QueryTriplet<>(first, second, third);
            pQ.add(qt);
        }

        for(int i = B; i < A.length; i++) {
            int dist = dist(A[i]);
            if(pQ.peek().getThird() > dist) {
                pQ.poll();
                int first = A[i][0];
                int second = A[i][1];
                QueryTriplet<Integer, Integer, Integer> qt = new QueryTriplet<>(first, second, dist);
                pQ.add(qt);
            }
        }

        int[][] result = new int[B][2];
        int k = 0;
        while(!pQ.isEmpty()) {
            QueryTriplet<Integer, Integer, Integer> qt = pQ.poll();
            result[k++] = new int[] {qt.getFirst(), qt.getSecond()};
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
