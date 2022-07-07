package com.scalar.ds.arrays.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author t0k02w6 on 13/01/22
 * @project scalar-ds
 */
public class SeparateOddEven {
    private static void segregateOddEven(int[] nums) {
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] % 2 == 0) {
                even.add(nums[i]);
            } else {
                odd.add(nums[i]);
            }
        }
        for(Integer el: odd) {
            System.out.print(el + " ");
        }
        System.out.println();
        for(Integer el: even) {
            System.out.print(el + " ");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nTestCases = scanner.nextInt();

        int i = 0;

        while(i < nTestCases) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for(int j = 0; j < n; j++) {
                nums[j] = scanner.nextInt();
            }
            segregateOddEven(nums);
            System.out.println();
            i++;
        }
    }
}
