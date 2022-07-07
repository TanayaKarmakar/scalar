package com.scalar.ds.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 04/07/22
 * @project scalar
 */
public class TrieNodeGenerics<T> {
    public boolean isFinished;
    public Map<T, TrieNodeGenerics<T>> children; // can be used hashmap as well
    int count;

    public TrieNodeGenerics() {
        this.children = new HashMap<>();
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public Map<T, TrieNodeGenerics<T>> getChildren() {
        return children;
    }

    public void setChildren(Map<T, TrieNodeGenerics<T>> children) {
        this.children = children;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
