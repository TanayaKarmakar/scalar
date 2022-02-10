package com.scalar.strings.homework;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author t0k02w6 on 10/02/22
 * @project scalar
 */
class Frequency implements Comparable<Frequency>{
    char ch;
    int freq;

    public Frequency(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }

    @Override
    public int compareTo(Frequency o) {
        if(this.freq == o.freq)
            return this.ch - o.ch;
        return this.freq - o.freq;
    }
}

public class ChangeCharacter {
    private static int solve(String A, int B) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < A.length(); i++) {
            map.put(A.charAt(i), map.getOrDefault(A.charAt(i), 0) + 1);
        }

        PriorityQueue<Frequency> pQ = new PriorityQueue<>();
        for(Map.Entry<Character, Integer> entry: map.entrySet()) {
            pQ.add(new Frequency(entry.getKey(), entry.getValue()));
        }

        while(B > 0) {
            Frequency q = pQ.poll();
            if(B >= q.freq) {
                B = B - q.freq;
            } else {
                q.freq = B;
                pQ.add(q);
                B = 0;
            }
        }
        return pQ.size();
    }

    public static void main(String[] args) {
        String str = "qghumeaylnlfdxfircvscxggbwkfnqduxwfnfozvsrtkjprepggxrpnrvystmwcysyycqpevikeffmznimkkasvwsrenzkycxfxtlsgypsfadpooefxzbcoejuvpvaboygpoeylfpbnpljvrvipyamyehwqnqrqpmxujjloovaowuxwhmsncbxcoksfzkvatxdknlyjyhfixjswnkkufnuxxzrzbmnmgqooketlyhnkoaugzqrcddiuteiojwayyzpvscmpsajlfvgubfaaovlzylntrkdcpwsrtesjwhdizcobzcnfwlqijtvdwvxhrcbldvgylwgbusbmborxtlhcsmpxohgmgnkeufdxotogbgxpeyanfetcukepzshkljugggekjdqzjenpevqgxiepjsrdzjazujllchhbfqmkimwzobiwybxduunfsksrsrtekmq";

        int ans = solve(str, 119);
        System.out.println(ans);
    }
}
