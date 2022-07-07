package com.scalar.ds.queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author t0k02w6 on 16/06/22
 * @project scalar
 */
public class FindTheNthPerfectNumber {
    private static boolean isPerfect(int newNumber) {
        String str = String.valueOf(newNumber);
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

    private static int nThPerfect(int[] nums, int n) {
        Deque<Integer> dq = new LinkedList<>();

        for(int i = 0; i < nums.length; i++) {
            dq.add(nums[i]);
        }

        while(!dq.isEmpty()) {
            int el = dq.poll();

            int base = el * 10;
            for(int i = 0; i < nums.length; i++) {
                int newNumber = base + nums[i];
                if(isPerfect(newNumber)) {
                    n--;
                    if(n == 0)
                        return newNumber;
                }
                dq.add(newNumber);
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = {1,2};
        int n = 4;

        int ans = nThPerfect(nums, 4);

        System.out.println(ans);
    }
}
