package com.scalar.ds.arrays.homework;

import java.util.Scanner;

/**
 * @author t0k02w6 on 12/01/22
 * @project scalar-ds
 */
public class SecondLargest {
    private static long secondLargest(long[] nums) {
        if(nums.length <= 1)
            return -1;

        long max = -1;
        long sMax = -1;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > max) {
                sMax = max;
                max = nums[i];
            }
            else if(nums[i] > sMax)
                sMax = nums[i];
        }
        return sMax;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nTestCases = Integer.parseInt(scanner.nextLine());

        int j = 0;
        while(j < nTestCases) {
            String str = scanner.nextLine();

            String[] inputStr = str.split("\\s+");
            int n = Integer.parseInt(inputStr[0]);

            long[] arr = new long[n];
            for(int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(inputStr[i + 1]);
            }

            System.out.println(secondLargest(arr));
            j++;
        }

        scanner.close();
    }
}
