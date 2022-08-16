package com.scalar.ds.dp.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author t0k02w6 on 01/08/22
 * @project scalar
 */
public class MinSumPathInTriangle {

    private static int minimumTotal(ArrayList<ArrayList<Integer>> a) {
        int nRow = a.size();
        int lastRowSize = a.get(nRow - 1).size();
        int m = nRow;
        int n = (lastRowSize * 2) - 1;
        int[][] matrix = new int[m][n];
        int start = 0;
        int end = n - 1;

        for(int i = 0; i < matrix.length; i++) {
            Arrays.fill(matrix[i], Integer.MAX_VALUE);
        }

        for(int i = nRow - 1; i >= 0; i--) {
            List<Integer> currentRow = a.get(i);
            int k = 0;
            for(int j = start; j <= end; j += 2) {
                matrix[i][j] = currentRow.get(k);
                k++;
            }
            start = start + 1;
            end = end - 1;
        }

        //int[][] dp = new int[m][n];
        for(int i = nRow - 2; i >= 0; i--) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] != Integer.MAX_VALUE) {
                    int option1 = (j - 1) >= 0 ? matrix[i + 1][j - 1]: 0;
                    int option2 = (j + 1) < n ? matrix[i + 1][j + 1]: 0;
                    matrix[i][j] = matrix[i][j] + Integer.min(option1, option2);
                }
            }
        }

//        int minValue = Integer.MAX_VALUE;
//        int minI = a.size() - 1;
//        int minJ = -1;
//
//        int totalSum = 0;
//
//        ArrayList<Integer> lastRow = a.get(a.size() - 1);
//        for(int i = 0; i < lastRow.size(); i++) {
//            if(minValue > lastRow.get(i)) {
//                minValue = lastRow.get(i);
//                minJ = i;
//            }
//        }
//        totalSum += minValue;
//        minI--;
//
//        while(minI > 0) {
//            ArrayList<Integer> currentRow = a.get(minI);
//            int option1 = Integer.MAX_VALUE;
//            if(minJ > 0) {
//                option1 = currentRow.get(minJ - 1);
//            }
//
//            int option2 = Integer.MAX_VALUE;
//            if(minJ < currentRow.size()) {
//                option2 = currentRow.get(minJ);
//            }
//
//            if(option1 > option2) {
//                totalSum += option2;
//            } else {
//                totalSum += option1;
//                minJ = minJ - 1;
//            }
//            minI--;
//        }
//        totalSum += a.get(0).get(0);
//        return totalSum;
        return matrix[0][(n - 1)/2];
    }


    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<>();
        current.add(2);
        input.add(current);

        current = new ArrayList<>();
        current.add(3);
        current.add(4);
        input.add(current);

        current = new ArrayList<>();
        current.add(6);
        current.add(5);
        current.add(7);
        input.add(current);

        current = new ArrayList<>();
        current.add(4);
        current.add(1);
        current.add(8);
        current.add(3);
        input.add(current);

        int ans = minimumTotal(input);

        System.out.println(ans);
    }
}
