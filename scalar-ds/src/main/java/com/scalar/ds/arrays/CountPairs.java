package com.scalar.ds.arrays;

/**
 * @author t0k02w6 on 08/01/22
 * @project scalar-ds
 */
public class CountPairs {
    private static int countPairs(char[] chars) {
        int n = chars.length;
        int countOfG = 0;
        int ans = 0;
        for(int i = n - 1; i >= 0; i--) {
            if(chars[i] == 'g') {
                countOfG++;
            } else if(chars[i] == 'a') {
                ans += countOfG;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        char[] chars = {'a','d','g','a','g','a','g','f','g'};

        int ans = countPairs(chars);

        System.out.println(ans);
    }
}
