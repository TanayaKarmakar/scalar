package com.scalar.ds.heaps.homework;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author t0k02w6 on 15/07/22
 * @project scalar
 */
public class NMaxPairCombinations {
    private static int[] solve(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int n = A.length;
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Comparator.reverseOrder());
        int count = 2;
        int start = n - 1;
        while(count > 0 && start >= 0) {
            int item = Integer.max(A[start], B[start]);
            if(item == A[start]) {
                for(int i = n - 1; i >= 0; i--) {
                    pQ.add(A[start] + B[i]);
                }
            } else {
                for(int i = n - 1; i >= 0; i--) {
                    pQ.add(B[start] + A[i]);
                }
            }
            count--;
            start--;
        }

        int[] result = new int[n];
        int i = 0;
        while(!pQ.isEmpty() && i < n) {
            result[i] = pQ.poll();
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {1};
        int[] B = {1};

        int[] ans = solve(A, B);

        System.out.println(Arrays.toString(ans));
    }
}
