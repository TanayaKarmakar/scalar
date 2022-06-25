package com.scalar.stack.advanced;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author t0k02w6 on 13/06/22
 * @project scalar
 */
public class NearestSmallerElement {
    private static int[] nearestSmallestElement(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int[] result = new int[n];
        result[0] = -1;
        stack.push(nums[0]);

        for(int i = 1; i < n; i++) {
            while(!stack.isEmpty() && stack.peek() >= nums[i]) {
                stack.pop();
            }
            if(stack.isEmpty())
                result[i] = -1;
            else
                result[i] = stack.peek();
            stack.push(nums[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4,6,2,8,6};

        int[] result = nearestSmallestElement(nums);

        System.out.println(Arrays.toString(result));
    }
}
