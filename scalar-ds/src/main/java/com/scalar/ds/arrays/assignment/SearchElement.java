package com.scalar.ds.arrays.assignment;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author t0k02w6 on 12/01/22
 * @project scalar-ds
 */
public class SearchElement {
    private static int searchElement(int[] nums, int b) {
        if(nums.length == 0)
            return 0;
        int start = 0;
        int end = nums.length - 1;
        Arrays.sort(nums);
        while(start <= end) {
            int mid = (start + end) >> 1;
            if(nums[mid] == b)
                return 1;
            else if(nums[mid] > b)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nTestCases = Integer.parseInt(scanner.nextLine());

        int j = 0;
        while(j < nTestCases) {
            String str = scanner.nextLine();

            String[] inputStr = str.split("\\s+");
            int n = Integer.parseInt(inputStr[0]);

            int[] arr = new int[n];
            for(int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputStr[i + 1]);
            }

            int b = Integer.parseInt(scanner.nextLine());

            System.out.println(searchElement(arr,b));
            j++;
        }
        scanner.close();
    }
}
