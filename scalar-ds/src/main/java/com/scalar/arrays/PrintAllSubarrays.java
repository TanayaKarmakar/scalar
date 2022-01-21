package com.scalar.arrays;

/**
 * @author t0k02w6 on 19/01/22
 * @project scalar-ds
 */
public class PrintAllSubarrays {
    private static void printSubarrays1(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < nums.length; j++) {
                StringBuilder sb = new StringBuilder();
                for(int k = i; k <= j; k++) {
                    sb.append(nums[k]).append(" ");
                }
                System.out.println(sb);
            }
        }
    }


    private static void printSubarrays(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            int end = nums.length;
            while(end > i) {
                for(int k = i; k < end; k++) {
                    System.out.print(nums[k] + " ");
                }
                System.out.println();
                end--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {4,2,10,3,12,-2,15};
        printSubarrays1(nums);
    }
}
