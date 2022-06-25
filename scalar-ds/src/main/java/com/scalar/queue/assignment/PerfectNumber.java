package com.scalar.queue.assignment;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author t0k02w6 on 18/06/22
 * @project scalar
 */
public class PerfectNumber {
    private static boolean isPerfectNumber(int num) {
        String str = String.valueOf(num);

        if(str.length() % 2 != 0)
            return false;

        int start = 0;
        int end = str.length() - 1;

        while(start <= end) {
            if(str.charAt(start) != str.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

    private static String solve(int A) {
        Queue<Integer> q = new LinkedList<>();
        int[] nums = {1,2};

        for(int i = 0; i < nums.length; i++) {
            q.add(nums[i]);
        }

        while(!q.isEmpty()) {
            int el = q.poll();
            int baseNum = el * 10;

            for(int i = 0; i < nums.length; i++) {
                int newNumber = baseNum + nums[i];
                if(isPerfectNumber(newNumber)) {
                    A--;
                    if(A == 0)
                        return String.valueOf(newNumber);
                }
                q.add(newNumber);
            }
        }
        return "-1";
    }

    public static void main(String[] args) {
        int A = 10;
        String ans = solve(A);

        System.out.println(ans);
    }
}
