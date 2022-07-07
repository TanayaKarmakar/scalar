package com.scalar.ds.trie;

/**
 * @author t0k02w6 on 01/07/22
 * @project scalar
 */
public class TrieService {
    public void insert(TrieNode root, String word) {
        TrieNode current = root;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(!current.getChildren().containsKey(ch)) {
                TrieNode node = new TrieNode();
                current.getChildren().put(ch, node);
            }
            current = current.children.get(ch);
        }
        current.isFinished = true;
    }

    public boolean search(TrieNode root, String word) {
        TrieNode current = root;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(!current.getChildren().containsKey(ch))
                return false;
            current = current.children.get(ch);
        }
        return current.isFinished;
    }

    public void insertWithCount(TrieNode root, String word) {
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

    public void delete(TrieNode root, String word) {
        deleteRec(root, word, -1);
    }


    private boolean deleteRec(TrieNode root, String word, int indx) {
        if(indx == word.length() - 1) {
            if(root.getChildren().isEmpty()) {
                root = null;
                return true;
            } else {
                root.isFinished = false;
                return false;
            }
        }

        char nextChar = word.charAt(indx + 1);
        TrieNode nextNode = root.getChildren().get(nextChar);
        boolean isChildrenDeleted = deleteRec(nextNode, word, indx + 1);
        if(isChildrenDeleted) {
            root.getChildren().remove(nextChar);
            if(root.getChildren().isEmpty() && !root.isFinished) {
                root = null;
                return true;
            }
        }
        return false;
    }
}
