package com.scalar.ds.arrays.assignment;

import java.util.Scanner;

/**
 * @author t0k02w6 on 12/01/22
 * @project scalar-ds
 */
public class ArrayRotation {
    private static void reverse(int[] nums,int start, int end) {
        while(start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }


    private static void rotate(int[] nums, int b) {
        if(nums.length == 0 || b == nums.length)
            return;
        if(b > nums.length)
            b = b % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, b - 1);
        reverse(nums, b, nums.length - 1);
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

        int b = Integer.parseInt(scanner.nextLine());

        rotate(arr, b);

        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        scanner.close();
    }
}
