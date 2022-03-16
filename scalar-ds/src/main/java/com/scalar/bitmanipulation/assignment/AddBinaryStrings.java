package com.scalar.bitmanipulation.assignment;

import java.util.Objects;
import java.util.Scanner;

/**
 * @author t0k02w6 on 26/01/22
 * @project scalar
 */
public class AddBinaryStrings {
    private static int populateResultAndFetchCarry(StringBuilder sb, Integer val1, Integer val2, int carry) {
        if(Objects.nonNull(val2)) {
            if(val1 == 0 && val2 == 0) {
                sb.insert(0, carry == 1 ? "1": "0");
                return 0;
            } else if(val1 == 1 && val2 == 1) {
                sb.insert(0, carry == 1 ? "1": "0");
                return 1;
            } else {
                sb.insert(0, carry == 1 ? "0": "1");
                return carry;
            }
        } else {
            if(val1 == 0) {
                sb.insert(0, carry == 1? "1": "0");
                return 0;
            } else {
                sb.insert(0, carry == 1? "0": "1");
                return carry;
            }
        }
    }

    private static String solve(String A, String B) {
        if(A.length() < B.length())
            return solve(B, A);

        int m = A.length();
        int n = B.length();

        int i = m - 1;
        int j = n - 1;

        int carry = 0;

        StringBuilder sb = new StringBuilder();
        while(i >= 0 && j >= 0) {
            Integer val1 = Integer.parseInt(A.charAt(i) + "");
            Integer val2 = Integer.parseInt(B.charAt(j) + "");
            carry = populateResultAndFetchCarry(sb, val1, val2, carry);
            i--;
            j--;
        }

        while(i >= 0) {
            Integer val1 = Integer.parseInt(A.charAt(i) + "");
            carry = populateResultAndFetchCarry(sb, val1, null, carry);
            i--;
        }

        if(carry == 1)
            sb.insert(0, "1");
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String A = scanner.nextLine();
        String B = scanner.nextLine();

        String result = solve(A, B);


        System.out.println(result);


        scanner.close();
    }
}
