package com.scalar.ds.revision.recursion.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author t0k02w6 on 26/08/22
 * @project scalar-ds
 */
public class TowerOfHanoi {
    private static int[][] towerOfHanoi(int A) {
        List<int[]> intermediate = new ArrayList<>();
        tohRec(A, 1, 3, 2, intermediate);
        int[][] finalResult = new int[intermediate.size()][];
        for(int i = 0; i < intermediate.size(); i++) {
            finalResult[i] = intermediate.get(i);
        }
        return finalResult;
    }

    private static void tohRec(int n, int src, int dest, int aux, List<int[]> result) {
        if(n == 1) {
            int[] entry = {1, src, dest};
            result.add(entry);
            return;
        }
        tohRec(n - 1, src, aux, dest, result);
        result.add(new int[] {n, src, dest});
        tohRec(n - 1, aux, dest, src, result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] result = towerOfHanoi(n);

        for(int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
        scanner.close();
    }
}
