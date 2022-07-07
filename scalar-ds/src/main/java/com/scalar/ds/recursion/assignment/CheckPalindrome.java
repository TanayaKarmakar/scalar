package com.scalar.ds.recursion.assignment;

import java.util.Scanner;

/**
 * @author t0k02w6 on 19/02/22
 * @project scalar
 */
public class CheckPalindrome {
    private static int palindromeRec(String A, int start, int end) {
        if(start >= end)
            return 1;
        if(A.charAt(start) != A.charAt(end))
            return 0;
        return palindromeRec(A, start + 1, end - 1);
    }

    private static int solve(String A) {
        return palindromeRec(A, 0,A.length() - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        int ans = solve(str);

        System.out.println(ans);
        scanner.close();
    }
}
