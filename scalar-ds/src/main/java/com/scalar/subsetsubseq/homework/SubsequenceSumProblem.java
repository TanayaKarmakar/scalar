package com.scalar.subsetsubseq.homework;

/**
 * @author t0k02w6 on 03/03/22
 * @project scalar
 */
public class SubsequenceSumProblem {
    private static int solve(int[] A, int B) {
        int n = A.length;
        int totalVal = (int)Math.pow(2, n);

        for(int i = 0; i < totalVal; i++) {
            int temp = i;
            int sum = 0;
            int l = 0;
            while(temp != 0) {
                if((temp & 1) == 1) {
                    sum += A[l];
                }
                if(sum == B)
                    return 1;
                temp = temp >> 1;
                l++;
            }
        }
        return 0;
    }

    public static void main(String[] args) {

    }
}
