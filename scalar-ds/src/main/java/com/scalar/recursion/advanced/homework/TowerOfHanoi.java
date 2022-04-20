package com.scalar.recursion.advanced.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author t0k02w6 on 20/04/22
 * @project scalar
 */
public class TowerOfHanoi {
    //private static int indx = 0;

    private static void tohRec(int A, List<int[]> list, int source, int intermediate, int dest) {
        if(A == 0) {
            return;
        }
        tohRec(A - 1, list,source, dest, intermediate);
        list.add(new int[]{A, source, dest});
        //System.out.println("Moving disk " + A + " from source " + source + " to dest " + dest);
        tohRec(A - 1, list, intermediate, source, dest);
    }

    private static int[][] towerOfHanoi(int A) {
        //indx = 0;
        int M = (int)Math.pow(2, A);
        List<int[]> list = new ArrayList<>();
        tohRec(A, list,1, 2, 3);
        int[][] grid = new int[list.size()][3];
        int indx = 0;
        for(int[] curr: list) {
            grid[indx++] = curr;
        }
        return grid;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[][] grid = towerOfHanoi(n);

        for(int i = 0; i < grid.length; i++) {
            System.out.println(Arrays.toString(grid[i]));
        }
        scanner.close();
    }
}
