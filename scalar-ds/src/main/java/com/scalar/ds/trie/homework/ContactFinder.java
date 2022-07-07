package com.scalar.ds.trie.homework;

import com.scalar.ds.trie.TrieNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author t0k02w6 on 04/07/22
 * @project scalar
 */
public class ContactFinder {
    private static void insertWord(TrieNode root, String word) {
        TrieNode current = root;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(!current.getChildren().containsKey(ch)) {
                TrieNode newNode = new TrieNode();
                current.getChildren().put(ch, newNode);
            }
            current = current.getChildren().get(ch);
            int count = current.getCount();
            current.setCount(count + 1);
        }
        current.isFinished = true;
    }

    private static int findNumberWordStartsWith(TrieNode root, String prefix) {
        TrieNode current = root;
        for(int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if(!current.getChildren().containsKey(ch))
                return 0;
            current = current.getChildren().get(ch);
        }
        return current.getCount();
    }

    private static int[] solve(int[] A, String[] B) {
        List<Integer> ans = new ArrayList<>();
        TrieNode root = new TrieNode();

        int n = A.length;
        for(int i = 0; i < n; i++) {
            if(A[i] == 0) {
                //insert
                insertWord(root, B[i]);
            } else {
                //find number of words starting with that
                ans.add(findNumberWordStartsWith(root, B[i]));
            }
        }

        int[] finalResult = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++) {
            finalResult[i] = ans.get(i);
        }

        return finalResult;
    }

    public static void main(String[] args) {
        int[] A = {0,0,1,1};
        String[] B = {"hack", "hacker", "hac", "hak"};

        int[] ans = solve(A, B);

        System.out.println(Arrays.toString(ans));
    }
}
