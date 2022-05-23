package com.scalar.strings.advanced.homework;

/**
 * @author t0k02w6 on 21/05/22
 * @project scalar-ds
 */
public class SmallestPrefixString {
    private static String smallestPrefix(String A, String B) {
            int m = A.length();
            int n = B.length();
            int i = 1;
            int j = 0;
            StringBuilder sb = new StringBuilder();
            sb.append(A.charAt(0));

        while(i < m && j < n) {
            if(A.charAt(i) < B.charAt(j)) {
                sb.append(A.charAt(i));
                i++;
            } else {
                sb.append(B.charAt(j));
                j++;
            }
            if(j > 0)
                return sb.toString();
        }

        if(i < m)
            sb.append(A.charAt(i));
        else if(j < n)
            sb.append(B.charAt(j));
        return sb.toString();
    }

    public static void main(String[] args) {

    }
}
