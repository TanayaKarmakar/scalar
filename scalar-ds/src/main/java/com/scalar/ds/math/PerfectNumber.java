package com.scalar.ds.math;

import java.util.Scanner;

/**
 * @author t0k02w6 on 05/01/22
 * @project scalar-ds
 */
public class PerfectNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] nums = new int[n];

        int i = 0;
        while(i < n) {
            nums[i] = scanner.nextInt();
            i++;
        }

        for(int i1 = 0; i1 < nums.length; i1++) {
            int val = nums[i1] / 2;

            int sum = 0;

            int i2 = 1;
            while(i2 <= val) {
                if(nums[i1] % i2 == 0) {
                    sum += i2;
                }
                i2++;
            }

            if(sum == nums[i1])
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
