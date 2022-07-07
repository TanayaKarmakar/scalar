package com.scalar.ds.twopointers.homework;

import java.util.HashSet;
import java.util.Set;

/**
 * @author t0k02w6 on 22/05/22
 * @project scalar-ds
 */
public class AnotherCountRectangles {
    private static int solve(int[] A, int B) {
        int n = A.length;
        int i = 0;
        int j = n - 1;
        //int count = 0;
        Set<String> set = new HashSet<>();

        while(i < n && j >= 0) {
            if(A[i] * A[i] < B) {
                set.add(A[i] + " - " + A[i]);
            }
            if(A[j] * A[j] < B) {
                set.add(A[j] + " - " + A[j]);
            }
            if(A[i] * A[j] < B) {
                set.add(A[i] + " - " + A[j]);
                i++;
                j--;
            } else {
                j--;
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
        int[] A = {1,2};
        int B = 5;
        int ans = solve(A, B);

        System.out.println(ans);
    }
}
