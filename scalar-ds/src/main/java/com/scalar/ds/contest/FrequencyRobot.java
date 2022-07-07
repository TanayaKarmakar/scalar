package com.scalar.ds.contest;

/**
 * @author t0k02w6 on 28/02/22
 * @project scalar-ds
 */
public class FrequencyRobot {
    private static int[] solve(int[] A) {
        int[] freq = new int[A.length];

        for(int i = 0; i < A.length; i++) {
            int start = (i - A[i]) >= 0 ? (i - A[i]) : 0;
            int end = (i + A[i]) < A.length ? (i + A[i]) : A.length - 1;
            for(int j = start; j <= end; j++) {
                freq[j]++;
            }
        }

        return freq;
    }

    public static void main(String[] args) {

    }
}
