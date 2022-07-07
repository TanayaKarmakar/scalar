package com.scalar.ds.trie;

/**
 * @author t0k02w6 on 03/07/22
 * @project scalar
 */
public class TrieTest {
    public static void main(String[] args) {
        String[] words = {"cat", "rat", "dog", "racoon", "tiger"};
        TrieService trieService = new TrieService();

        TrieNode root = new TrieNode();
        for(String word: words) {
            trieService.insert(root, word);
        }

        String deleteWord = "rat";
        trieService.delete(root, deleteWord);

        System.out.println(trieService.search(root, "rat"));
    }
}
