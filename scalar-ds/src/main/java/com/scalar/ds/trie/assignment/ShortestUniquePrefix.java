package com.scalar.ds.trie.assignment;

import com.scalar.ds.trie.TrieNode;

/**
 * @author t0k02w6 on 02/07/22
 * @project scalar
 */
public class ShortestUniquePrefix {


    private static String[] prefix(String[] A) {
        TrieNode root = new TrieNode();
        insertWords(root, A);

        String[] result = new String[A.length];
        for(int i = 0; i < A.length; i++) {
            StringBuilder sb = smallestPrefixForWord(root, A[i]);
            result[i] = sb.toString();
        }
        return result;
    }

    private static StringBuilder smallestPrefixForWord(TrieNode root, String word) {
        TrieNode current = root;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            sb.append(ch);
            if(current.getChildren().get(ch).getCount() == 1) {
                break;
            }
            current = current.children.get(ch);
        }
        return sb;
    }

    private static void insertWords(TrieNode root, String[] words) {
        for(String word: words) {
            insertWord(root, word);
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
            current = current.getChildren().get(ch);
            int count = current.getCount();
            current.setCount(count + 1);
        }
        current.isFinished = true;
    }

    public static void main(String[] args) {

    }
}
