package com.scalar.ds.math.advanced.combinatorics.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author t0k02w6 on 11/04/22
 * @project scalar
 */
public class ComputeNcRmodM {
    private static int solve(int A, int B, int C) {
        List<List<Integer>> triangle = new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        list.add(1);
        triangle.add(list);

        for(int i = 1; i <= A; i++) {
            list = new ArrayList<>();
            for(int j = 0; j <= i; j++) {
                if(j == 0 || j == i)
                    list.add(1);
                else {
                    int val = ((triangle.get(i - 1).get(j - 1) % C)
                            + (triangle.get(i - 1).get(j) % C)) % C;
                    list.add(val);
                }
            }
            triangle.add(list);
        }
        return triangle.get(A).get(B);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();

        int ans = solve(A, B, C);

        System.out.println(ans);

        scanner.close();
    }
}
