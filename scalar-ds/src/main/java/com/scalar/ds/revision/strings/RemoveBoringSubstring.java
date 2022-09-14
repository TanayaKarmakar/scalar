package com.scalar.ds.revision.strings;

/**
 * @author t0k02w6 on 05/09/22
 * @project scalar-ds
 */
public class RemoveBoringSubstring {
    private static void populateValue(StringBuilder sb, int k, int indx) {
        while(k > 0) {
            sb.append((char)(indx + 'a'));
            k--;
        }
    }


    private static String removeBoringString(String str) {
        int[] freq = new int[26];
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            freq[ch - 'a']++;
        }

        StringBuilder oddSb = new StringBuilder();
        StringBuilder evenSb = new StringBuilder();
        for(int i = 0; i < 26; i++) {
            if(i % 2 == 0) {
                if(freq[i] >= 1) {
                    populateValue(evenSb, freq[i], i);
                }
            } else {
                if(freq[i] >= 1) {
                    populateValue(oddSb, freq[i], i);
                }
            }
        }
        String oddStr = oddSb.toString();
        String evenStr = evenSb.toString();
        StringBuilder resultSb = new StringBuilder();
        if(Math.abs(evenStr.charAt(0) - oddStr.charAt(evenStr.length() - 1)) > 1) {
            resultSb.append(evenStr.substring(1));
            resultSb.append(evenStr.charAt(0));
            resultSb.append(oddStr.charAt(oddStr.length() - 1));
            resultSb.append(oddStr, 0, oddStr.length() - 1);
        }
        return resultSb.toString();
    }

    public static void main(String[] args) {
        String str = "aebcfghdbc";

        String ans = removeBoringString(str);

        System.out.println(ans);
    }
}
