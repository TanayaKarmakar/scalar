package com.scalar.ds.strings.advanced.assignment;

/**
 * @author t0k02w6 on 25/05/22
 * @project scalar
 */
public class PermutationsOfAInB {
    private static int solve(String A, String B) {
        int[] aFreq = new int[26];
        int[] bFreq = new int[26];

        int l = 0;
        int r = 0;
        int count = 0;
        for(r = 0; r < A.length(); r++) {
            aFreq[A.charAt(r) - 'a']++;
            bFreq[B.charAt(r) - 'a']++;
        }

        while(r < B.length()) {
            boolean isMatch = true;
            for(int i = 0; i < 26; i++) {
                if(aFreq[i] != bFreq[i]) {
                    isMatch = false;
                    break;
                }
            }
            if(isMatch) {
                count++;
            }
            bFreq[B.charAt(r) - 'a']++;
            r++;
            bFreq[B.charAt(l) - 'a']--;
            l++;
        }
        boolean isMatch = true;
        for(int i = 0; i < 26; i++) {
            if(aFreq[i] != bFreq[i]) {
                isMatch = false;
                break;
            }
        }
        if(isMatch) {
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        String a = "ebbp";
        String b = "qaoedpcebeaqocbacoccqoebpqdoqcpbdbqcecdoqcpebqpebbabqdpepcpbqbepbabocpc";

        int count = solve(a, b);

        System.out.println(count);
    }
}
