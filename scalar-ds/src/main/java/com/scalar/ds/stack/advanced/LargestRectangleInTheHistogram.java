package com.scalar.ds.stack.advanced;

import java.util.Stack;

/**
 * @author t0k02w6 on 14/06/22
 * @project scalar
 */
public class LargestRectangleInTheHistogram {
    private static int largestRect(int[] nums) {
        int n = nums.length;
        int[] nsel = new int[n];

        Stack<Integer> stack = new Stack<>();
        nsel[0] = 0;
        stack.push(0);

        for(int i = 1; i < n; i++) {
            while(!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            if(stack.isEmpty())
                nsel[i] = 0;
            else
                nsel[i] = stack.peek() + 1;
            stack.push(i);
        }

        stack.clear();
        int[] nser = new int[n];
        nser[n - 1] = (n - 1);
        stack.push((n - 1));
        for(int i = n - 2; i >= 0; i--) {
            while(!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            if(stack.isEmpty())
                nser[i] = (n - 1);
            else
                nser[i] = stack.peek() - 1;
            stack.push(i);
        }

        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            ans = Integer.max(ans, (nser[i] - nsel[i] + 1) * nums[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2,1,5,6,2,3,1};

        int ans = largestRect(nums);

        System.out.println(ans);
    }
}
