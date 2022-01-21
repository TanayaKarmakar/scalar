package com.scalar.arrays;

/**
 * @author t0k02w6 on 19/01/22
 * @project scalar-ds
 */
public class SumOfAllSubarrays {
    private static long solveOptimized(int[] nums) {
        long totalSum = 0;
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < nums.length; j++) {
                if(i == 0) {
                    totalSum += prefixSum[j];
                } else if(j >= i){
                    totalSum += (prefixSum[j] - prefixSum[i - 1]);
                }
            }
        }
        return totalSum;
    }

    private static long solveOptimized1(int[] nums) {
        long finalSum = 0;
        for(int i = 0; i < nums.length; i++) {
            long currentSum = 0;
            for(int j = i; j < nums.length; j++) {
                currentSum += nums[j];
                finalSum += currentSum;
            }
        }
        return finalSum;
    }


    //O(N) solution
    private static long solveOptimized2(int[] nums) {
        long finalSum = 0;


        for(int i = 0; i < nums.length; i++) {
            int start = (i + 1);
            int end = (nums.length - i);
            long count = (long)start * end;
            finalSum += count * (long) nums[i];
        }
        return finalSum;
    }


    private static long solve(int[] nums) {
        long totalSum = 0;
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < nums.length; j++) {
                long currentSum = 0;
                for(int k = i; k <= j; k++) {
                    currentSum += nums[k];
                }
                totalSum += currentSum;
            }
        }
        return totalSum;
    }

    public static void main(String[] args) {
        int[] nums = {4,2,10,3,12,-2,15};
        long ans = solve(nums);

        System.out.println("Naive - " + ans);

        ans = solveOptimized(nums);

        System.out.println("Optimized - " + ans);

        ans = solveOptimized1(nums);

        System.out.println("Optimized1 - " + ans);

        ans = solveOptimized2(nums);

        System.out.println("Optimized2 - " + ans);
    }
}
