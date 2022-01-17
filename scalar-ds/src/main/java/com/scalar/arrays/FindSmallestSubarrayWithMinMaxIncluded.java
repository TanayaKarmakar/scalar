package com.scalar.arrays;

/**
 * @author t0k02w6 on 16/01/22
 * @project scalar-ds
 */
public class FindSmallestSubarrayWithMinMaxIncluded {
    private static int solveBruteForce(int[] nums) {
        int min = nums[0];
        int max = nums[0];

        for(int i = 1; i < nums.length; i++) {
            min = Integer.min(min, nums[i]);
            max = Integer.max(max, nums[i]);
        }

        int minDiff = nums.length;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == max) {
                for(int j = i; j < nums.length; j++) {
                    if(nums[j] == min) {
                        minDiff = Integer.min(minDiff, (j - i + 1));
                        break;
                    }
                }
            } else if(nums[i] == min) {
                for(int j = i; j < nums.length; j++) {
                    if(nums[j] == max) {
                        minDiff = Integer.min(minDiff, (j - i + 1));
                        break;
                    }
                }
            }
        }
        return minDiff;
    }

    private static int solveOptimal(int[] nums) {
        int min = nums[0];
        int max = nums[0];

        for(int i = 1; i < nums.length; i++) {
            min = Integer.min(min, nums[i]);
            max = Integer.max(max, nums[i]);
        }

        int minIndx = -1;
        int maxIndx = -1;
        int minDiff = nums.length;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == min) {
                minIndx = i;
                if(maxIndx != -1) {
                    minDiff = Integer.min(minDiff, Math.abs(maxIndx - minIndx) + 1);
                }
            } if(nums[i] == max) {
                maxIndx = i;
                if(minIndx != -1) {
                    minDiff = Integer.min(minDiff, Math.abs(maxIndx - minIndx) + 1);
                }
            }
        }

        return minDiff;
    }

    public static void main(String[] args) {
        int[] nums = {1,6,4,2,7,7,5,1,3,1,1,5};
        int ans = solveBruteForce(nums);

        System.out.println("BruteForce - " + ans);

        ans = solveOptimal(nums);

        System.out.println("Optimal - " + ans);

        nums = new int[] {8,8,8,8,8};

        ans = solveBruteForce(nums);

        System.out.println("BruteForce - " + ans);

        ans = solveOptimal(nums);

        System.out.println("Optimal - " + ans);
    }
}
