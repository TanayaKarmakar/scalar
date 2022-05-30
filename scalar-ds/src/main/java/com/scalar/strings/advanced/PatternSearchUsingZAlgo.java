package com.scalar.strings.advanced;

/**
 * @author t0k02w6 on 25/05/22
 * @project scalar-ds
 */
public class PatternSearchUsingZAlgo {
    private static boolean isPatternPresent(String str, String pattern) {
        StringBuilder sb = new StringBuilder();
        sb.append(pattern);
        sb.append("#");
        sb.append(str);

        String newStr = sb.toString();
        int s = 0;
        int e = 0;
        int count = 0;
        int n = newStr.length();

        int[] z = new int[n];
        z[0] = n;

        for(int i = 1; i < n; i++) {
            if(i > e) {
                s = e = i;
                count = 0;
                while(e < n && newStr.charAt(e) == newStr.charAt(e - s)) {
                    count++;
                    e++;
                }
                z[i] = count;
                e--;
            } else {
                if(i + z[i - s] <= e)
                    z[i] = z[i - s];
                else {
                    count = 0;
                    if(i - s > 0)
                        count = z[i - s];
                    s = i;
                    while(e < n && newStr.charAt(e) == newStr.charAt(e - s)) {
                        e++;
                        count++;
                    }
                    z[i] = count;
                    e--;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            if(z[i] == pattern.length())
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "abdabtyabca";
        String pattern = "abc";

        boolean isPresent = isPatternPresent(str, pattern);

        System.out.println(isPresent);
    }
}
