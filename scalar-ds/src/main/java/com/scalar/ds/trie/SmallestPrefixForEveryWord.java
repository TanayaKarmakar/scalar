package com.scalar.ds.trie;

import java.util.Arrays;

/**
 * @author t0k02w6 on 02/07/22
 * @project scalar
 */
public class SmallestPrefixForEveryWord {

    private static void insertWord(TrieNode root, String word) {
        TrieNode current = root;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(!current.getChildren().containsKey(ch)) {
                TrieNode newNode = new TrieNode();
                current.getChildren().put(ch, newNode);
            }
            current = current.getChildren().get(ch);
            current.count++;
        }
        current.isFinished = true;
    }

    private static String[] smallestUniquePrefix(TrieNode root, String[] words) {
        String[] result = new String[words.length];
        for(int i = 0; i < words.length; i++) {
            StringBuilder sb = smallestPrefixForWord(root, words[i]);
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
            if(current.getChildren().get(ch).count == 1) {
                break;
            }
            current = current.children.get(ch);
        }
        return sb;
    }

    private static TrieNode insert(String[] words) {
        TrieNode root = new TrieNode();
        for(String word: words) {
            insertWord(root, word);
        }
        return root;
    }

    public static void main(String[] args) {
        String[] strs = {"cat", "dog", "rat", "tiger", "racoon"};
        TrieNode root = insert(strs);
        String[] prefixes = smallestUniquePrefix(root, strs);

        System.out.println(Arrays.toString(prefixes));
    }
}
