package com.scalar.ds.arrays.assignment;

/**
 * @author t0k02w6 on 18/01/22
 * @project scalar-ds
 */
public class LightBulb {
    private static int bulbsOptimized(int[] A) {
        boolean flip = false;
        int count = 0;
        for(int i = 0; i < A.length; i++) {
            if(!flip && A[i] == 0) {
                flip = true;
                count++;
            } else if(flip && A[i] == 1) {
                flip = false;
                count++;
            }
        }
        return count;
    }


    private static int bulbs(int[] A) {
        int count = 0;
        for(int i = 0; i < A.length; i++) {
            if(A[i] == 0) {
                count++;
                for(int j = i + 1; j < A.length; j++) {
                    A[j] = (A[j] == 0) ? 1: 0;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,1};
        int count = bulbsOptimized(nums);

        System.out.println(count);
    }
}
