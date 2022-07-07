package com.scalar.ds.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 01/07/22
 * @project scalar
 */
public class TrieNode {
    public boolean isFinished;
    public Map<Character, TrieNode> children; // can be used hashmap as well
    int count;

    public TrieNode() {
        this.children = new HashMap<>();
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public Map<Character, TrieNode> getChildren() {
        return children;
    }

    public void setChildren(Map<Character, TrieNode> children) {
        this.children = children;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
