package com.scalar.ds.trie.homework;


import com.scalar.ds.trie.TrieNode;

import java.util.Map;

/**
 * @author t0k02w6 on 04/07/22
 * @project scalar
 */
public class ModifiedSearch {
    private static void insertWord(TrieNode root, String word) {
        TrieNode current = root;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(!current.getChildren().containsKey(ch)) {
                TrieNode newNode = new TrieNode();
                current.getChildren().put(ch, newNode);
            }
            current = current.getChildren().get(ch);
        }
        current.isFinished = true;
    }

//    private static boolean searchWord(TrieNode root, String word, int indx) {
//        if(indx >= word.length() - 1)
//            return root.isFinished;
//        char ch = word.charAt(indx);
//        Map<Character, TrieNode> map = root.getChildren();
//        for(Map.Entry<Character, TrieNode> entry: map.entrySet()) {
//
//        }
//    }

    private static int fuzzySearchWithOneModification(TrieNode root, String searchKey) {
        TrieNode current = root;
        TrieNode temp;
        int modificationCount = 0;
        for(int i = 0; i < searchKey.length(); i++) {
            char ch = searchKey.charAt(i);
            if(!current.getChildren().containsKey(ch)) {
                modificationCount++;
                temp = current;
                Map<Character, TrieNode> map = current.getChildren();
                for(Map.Entry<Character, TrieNode> entry: map.entrySet()) {
                    current = current.getChildren().get(entry.getKey());
                    //searchWord
                }
            } else {
                current = current.getChildren().get(ch);
            }
        }
        return 0;
    }

    private static String solve(String[] A, String[] B) {
        TrieNode root = new TrieNode();
        for(String word: A) {
            insertWord(root, word);
        }

        StringBuilder sb = new StringBuilder();
        for(String searchKey: B) {

        }
        return "";
    }

    public static void main(String[] args) {

    }
}
