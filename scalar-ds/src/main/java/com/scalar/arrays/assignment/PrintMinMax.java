package com.scalar.arrays.assignment;

import java.util.Scanner;

/**
 * @author t0k02w6 on 12/01/22
 * @project scalar-ds
 */
public class PrintMinMax {
    private static void printMinMax(int[] nums) {
        if(nums.length == 0)
            return;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++) {
            min = Integer.min(min, nums[i]);
            max = Integer.max(max, nums[i]);
        }

        System.out.println(max + " " + min);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        String[] inputStr = str.split("\\s+");
        int n = Integer.parseInt(inputStr[0]);

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(inputStr[i + 1]);
        }

        printMinMax(arr);

        scanner.close();
    }
}
