package com.scalar.ds.revision.recursion;

import java.util.Scanner;

/**
 * @author t0k02w6 on 26/08/22
 * @project scalar-ds
 */
public class GetKthIndexFromNthRow {
    private static int getKthSymbol(int n, int k) {
        if(k == 0 || n == 0)
            return 0;
        int parentNode = getKthSymbol(n - 1, k / 2);
        if(k % 2 == 0)
            return parentNode;
        return 1 - parentNode;
    }


    private static int getNthRow(int n, int k) {
        String str = getNthRowRec(n, "0");

        System.out.println(str);
        return (str.charAt(k) - '0');
    }

    private static String getNthRowRec(int n, String current) {
        if(n == 0)
            return current;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < current.length(); i++) {
            char ch = current.charAt(i);
            if(ch == '0')
                sb.append("01");
            else
                sb.append("10");
        }
        return getNthRowRec(n - 1, sb.toString());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int ans = getNthRow(n, k);

        System.out.println(ans);

        scanner.close();
    }
}
