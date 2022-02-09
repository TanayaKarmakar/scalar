package com.scalar.strings.assignment;

/**
 * @author t0k02w6 on 09/02/22
 * @project scalar-ds
 */
public class SimpleReverse {
    private static String solve(String A) {
        char[] arr = A.toCharArray();

        int start = 0;
        int end = arr.length - 1;
        while(start < end) {
            char tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            start++;
            end--;
        }

        return new String(arr);
    }

    public static void main(String[] args) {
        String str = "scalar";

        System.out.println(solve(str));
    }
}
