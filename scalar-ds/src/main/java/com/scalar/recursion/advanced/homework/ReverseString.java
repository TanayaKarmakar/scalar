package com.scalar.recursion.advanced.homework;

import java.util.Scanner;

/**
 * @author t0k02w6 on 16/04/22
 * @project scalar
 */
public class ReverseString {
    private static String reverseString(String str) {
        char[] arr = str.toCharArray();
        reverseRec(arr, 0, str.length() - 1);
        return new String(arr);
    }

    private static void reverseRec(char[] arr, int start, int end) {
        if(start >= end)
            return;
        char tmp = arr[start];
        arr[start] = arr[end];
        arr[end] = tmp;
        reverseRec(arr, start + 1, end - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        str = reverseString(str);

        System.out.println(str);

        scanner.close();
    }
}
