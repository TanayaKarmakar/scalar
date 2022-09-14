package com.scalar.ds.revision.strings;

/**
 * @author t0k02w6 on 07/09/22
 * @project scalar-ds
 */
public class PatternSearchUsingZAlgo {
    private static int patternSearch(String pattern, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(pattern);
        sb.append("#");
        sb.append(str);


        String newStr = sb.toString();
        int[] z = new int[newStr.length()];
        z[0] = newStr.length();
        int s = 0;
        int e = 0;
        int count = 0;
        for(int i = 1; i < newStr.length(); i++) {
            if(i > e) {
                s = e = i;
                count = 0;
                e++;
                while(e < newStr.length() && str.charAt(e) == str.charAt(e - s)) {
                    e++;
                    count++;
                }
                z[i] = count;
                e--;
            } else {
                if(i + z[i - s] <= e) {
                    z[i] = z[i - s];
                } else {
                    count = 0;
                    if(i - s > 0) {
                        count = z[i - s];
                    }
                    s = e = i;
                    e++;
                    while(e < newStr.length() && str.charAt(e) == str.charAt(e - s)) {
                        e++;
                        count++;
                    }
                    z[i] = count;
                    e--;
                }
            }
        }
        for(int i = 1; i < z.length; i++) {
            if(z[i] == pattern.length()) {
                return str.charAt(i - pattern.length() - 1);
            }
        }
        return -1;
    }

    public static void main(String[] args) {



    }
}
