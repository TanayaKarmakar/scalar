package com.scalar.ds.strings.advanced.assignment;

/**
 * @author t0k02w6 on 21/05/22
 * @project scalar-ds
 */
public class CyclicPermutation {
    private static int solve(String A, String B) {
        B = B + B;
        B = B.substring(0, B.length() - 1);
        StringBuilder sb = new StringBuilder();
        sb.append(A);
        sb.append("#");
        sb.append(B);
        String newStr = sb.toString();

        int n = newStr.length();
        int[] z = new int[n];

        z[0] = n;

        int s = 0;
        int e = 0;
        int count = 0;
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
                if(i + z[i - s] <= e) {
                    z[i] = z[i - s];
                } else {
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

        int occurenceCount = 0;
        for(int i = 0; i < n; i++) {
            if(z[i] == A.length())
                occurenceCount++;
        }
        return occurenceCount;
    }

    public static void main(String[] args) {
        String A = "1101111111";
        String B = "1101111111";
        int ans = solve(A, B);

        System.out.println(ans);

        A = "1001";
        B = "0011";
        ans = solve(A, B);

        System.out.println(ans);
    }
}
