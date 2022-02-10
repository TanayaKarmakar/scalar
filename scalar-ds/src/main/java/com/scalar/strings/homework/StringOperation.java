package com.scalar.strings.homework;

/**
 * @author t0k02w6 on 10/02/22
 * @project scalar
 */
public class StringOperation {
    private static String solve(String A) {
        StringBuilder sb = new StringBuilder();
        sb.append(A);
        sb.append(A);

        String newString = sb.toString();
        char[] arr = newString.toCharArray();
        sb = new StringBuilder();
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] >= 'A' && arr[i] <= 'Z') {
                continue;
            } else if(arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i'
                    || arr[i] == 'o' || arr[i] == 'u') {
                arr[i] = '#';
            }
            sb.append(arr[i]);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "AbcaZeoB";

        System.out.println(solve(str));
    }
}
