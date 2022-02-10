package com.scalar.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * @author t0k02w6 on 09/02/22
 * @project scalar-ds
 */
public class ReverseWordsWithoutUsingSplit {
    private static String reverse(String str) {
        char[] arr = str.toCharArray();

        List<String> words = new ArrayList<>();
        int n = arr.length;
        int i = 0;
        while(i < n) {
            int j = i + 1;
            while(j < n && arr[j] != ' ') {
                j++;
            }
            words.add(str.substring(i, j));
            i = j + 1;
        }

        int start = 0;
        int end = words.size() - 1;
        while(start < end) {
            String tmp = words.get(start);
            words.set(start, words.get(end));
            words.set(end, tmp);
            start++;
            end--;
        }

        StringBuilder sb = new StringBuilder();
        for(String word: words) {
            sb.append(word).append(" ");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "the sky is blue";

        System.out.println(reverse(str));
    }
}
