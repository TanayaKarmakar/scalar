package com.scalar.ds.dp.homework;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author t0k02w6 on 01/08/22
 * @project scalar
 */
public class MinimumFallingPathSumII {
    private static int solve(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        ArrayList<Integer> lastRow = A.get(n - 1);
        int minValue = Integer.MAX_VALUE;
        Set<Integer> colSet = new HashSet<>();
        int minColIndx = -1;
        for(int i = 0; i < lastRow.size(); i++) {
            if(lastRow.get(i) < minValue) {
                minValue = lastRow.get(i);
                minColIndx = i;
            }
        }
        colSet.add(minColIndx);

        int i = n - 2;
        int total = minValue;
        while(i >= 0) {
            ArrayList<Integer> currentRow = A.get(i);
            minValue = Integer.MAX_VALUE;
            for(int j = 0; j < n; j++) {
                if(currentRow.get(j) < minValue && !colSet.contains(j)) {
                    minValue = lastRow.get(i);
                    minColIndx = j;
                }
            }
            colSet.add(minColIndx);
            total += minValue;
            i--;
        }
        return total;
    }

    public static void main(String[] args) {

    }
}
