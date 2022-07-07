package com.scalar.ds.moduloarithmetic.assignment;

import java.util.Scanner;

/**
 * @author t0k02w6 on 02/02/22
 * @project scalar-ds
 */
public class ExcelColumnNumber {
    private static int titleToNumber(String A) {
        int ans = 0;
        int MOD = 1000000007;

        for(int i = 0; i < A.length(); i++) {
            ans = ((ans * 26) % MOD + ((int)A.charAt(i) - 65 + 1)) % MOD;
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();

        int ans = titleToNumber(str);

        System.out.println(ans);

        scanner.close();
    }
}
