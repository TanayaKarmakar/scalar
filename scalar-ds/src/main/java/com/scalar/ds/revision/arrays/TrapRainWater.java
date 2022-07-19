package com.scalar.ds.revision.arrays;

/**
 * @author t0k02w6 on 17/07/22
 * @project scalar
 */
public class TrapRainWater {
    private static int totalWater(int[] heights) {
        int n = heights.length;
        int left = 0;
        int right = n - 1;
        int lMax = Integer.MIN_VALUE;
        int rMax = Integer.MIN_VALUE;
        int total = 0;
        while(left < right) {
            if(heights[left] < heights[right]) {
                lMax = Integer.max(lMax, heights[left]);
                total += (lMax - heights[left]);
                left++;
            } else {
                rMax = Integer.max(rMax, heights[right]);
                total += (rMax - heights[right]);
                right--;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1};

        int ans = totalWater(heights);

        System.out.println(ans);
    }
}
