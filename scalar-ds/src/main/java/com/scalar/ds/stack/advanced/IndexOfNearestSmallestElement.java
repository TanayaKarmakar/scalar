package com.scalar.ds.stack.advanced;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author t0k02w6 on 14/06/22
 * @project scalar
 */
public class IndexOfNearestSmallestElement {
    private static int[] nearestSmallestElement(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        Stack<Integer> stack = new Stack<>();

        result[0] = -1;
        stack.push(0);

        for(int i = 1; i < n; i++) {
            while(!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }

            if(stack.isEmpty())
                result[i] = -1;
            else
                result[i] = stack.peek();
            stack.push(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4,6,2,8,6};

        int[] ans = nearestSmallestElement(nums);

        System.out.println(Arrays.toString(ans));
    }
}
