package com.scalar.ds.revision.arrays;

import java.util.Arrays;

/**
 * @author t0k02w6 on 17/07/22
 * @project scalar
 */
public class BeggarsOutsideTemple {
    private static int[] findTotalAmount(int[][] queries, int n) {
        int[] beggars = new int[n];

        for(int i = 0; i < queries.length; i++) {
            int[] currentQuery = queries[i];
            beggars[currentQuery[0]] = currentQuery[1];
        }

        for(int i = 1; i < n; i++) {
            beggars[i] += beggars[i - 1];
        }
        return beggars;
    }

    public static void main(String[] args) {
        int[][] queries = {{1,3},{4,2},{2,1},{4,3}};
        int n = 8;
        int[] ans = findTotalAmount(queries, n);

        System.out.println(Arrays.toString(ans));
    }
}
