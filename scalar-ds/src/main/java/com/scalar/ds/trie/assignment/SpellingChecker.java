package com.scalar.ds.trie.assignment;

import com.scalar.ds.trie.TrieNode;

import java.util.Arrays;

/**
 * @author t0k02w6 on 02/07/22
 * @project scalar
 */
public class SpellingChecker {
    private static void insertWords(TrieNode root, String[] A) {
        for(int i = 0; i < A.length; i++) {
            insertWord(root, A[i]);
        }
     }

    private static void insertWord(TrieNode root, String word) {
        TrieNode current = root;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(!current.getChildren().containsKey(ch)) {
                TrieNode newNode = new TrieNode();
                current.getChildren().put(ch, newNode);
            }
            current = current.children.get(ch);
        }
        current.isFinished = true;
    }

    private static boolean search(TrieNode root, String word) {
        TrieNode current = root;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(!current.getChildren().containsKey(ch))
                return false;
            current = current.getChildren().get(ch);
        }
        return current.isFinished;
    }

    private static int[] solve(String[] A, String[] B) {
        TrieNode root = new TrieNode();
        insertWords(root, A);

        int[] result = new int[B.length];
        for(int i = 0; i < B.length; i++) {
            boolean isPresent = search(root, B[i]);
            result[i] = isPresent ? 1: 0;
        }
        return result;
    }



    public static void main(String[] args) {
        String[] words = {"A", "B"};
        String[] searchKeys = {"A", "B"};

        int[] res = solve(words, searchKeys);

        System.out.println(Arrays.toString(res));
    }
}
