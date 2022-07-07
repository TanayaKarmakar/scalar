package com.scalar.ds.recursion.assignment;

import java.util.Scanner;

/**
 * @author t0k02w6 on 19/02/22
 * @project scalar
 */
public class ReverseString {
    private static void printReverseRec(char[] arr, int start, int end) {
        if(start > end)
            return;
        char tmp = arr[start];
        arr[start] = arr[end];
        arr[end] = tmp;
        printReverseRec(arr, start + 1, end - 1);
    }

    private static String printReverse(String s) {
        char[] arr = s.toCharArray();
        printReverseRec(arr, 0, s.length() - 1);
        return new String(arr);
    }

    public static void main(String[] args) {
//        String str = "tanaya";
//
//        String ans = printReverse(str);
//
//        System.out.println(ans);

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        String ans = printReverse(str);

        System.out.println(ans);

        scanner.close();
    }
}
