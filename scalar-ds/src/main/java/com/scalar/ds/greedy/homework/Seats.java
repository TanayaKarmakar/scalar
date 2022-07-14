package com.scalar.ds.greedy.homework;

import java.util.PriorityQueue;

/**
 * @author t0k02w6 on 14/07/22
 * @project scalar
 */
public class Seats {
    private static int seats(String A) {
        char[] arr = A.toCharArray();
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        int prev = -1;
        long total = 0;
        int mod = 100000003;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 'x') {
                if(prev == -1)
                    prev = i;
                else {
                    if(i - prev > 1)
                        total += (i - prev - 1);
                    prev = i;
                }
            }
        }
        return (int)(total % mod);
    }

    public static void main(String[] args) {
        String str = "....x..xx...x..";
        int ans = seats(str);

        System.out.println(ans);
    }
}
