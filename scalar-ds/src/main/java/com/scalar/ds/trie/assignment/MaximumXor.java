package com.scalar.ds.trie.assignment;

import com.scalar.ds.trie.TrieNodeGenerics;

/**
 * @author t0k02w6 on 09/07/22
 * @project scalar
 */
public class MaximumXor {
    private static int solve(int[] A) {
        TrieNodeGenerics<Integer> root = new TrieNodeGenerics<>();
        for(int el: A) {
            insertElement(root, el);
        }

        int maxXor = Integer.MIN_VALUE;
        for(int el: A) {
            int num = findPairForMaximumXor(root, el);
            int xor = (el ^ num);
            maxXor = Integer.max(maxXor, xor);
        }
        return maxXor;
    }

    private static int findPairForMaximumXor(TrieNodeGenerics<Integer> root, int el) {
        TrieNodeGenerics<Integer> current = root;
        int result = 0;
        for(int i = 31; i >= 0; i--) {
            int currentRotation = (el >> i);
            int currentBit = (currentRotation & 1);
            int searchBit = 1 - currentBit;
            int acceptedbit = 0;
            if(current.getChildren().containsKey(searchBit)) {
                acceptedbit = searchBit;
            } else {
                acceptedbit = currentBit;
            }
            current = current.getChildren().get(acceptedbit);
            result = (result << 1);
            result += acceptedbit;
        }
        return result;
    }

    private static void insertElement(TrieNodeGenerics<Integer> root, int el) {
        TrieNodeGenerics<Integer> current = root;
        for(int i = 31; i >= 0; i--) {
            int currentRotation = (el >> i);
            int currentbit = (currentRotation & 1);
            if(!current.getChildren().containsKey(currentbit)) {
                TrieNodeGenerics<Integer> node = new TrieNodeGenerics<>();
                current.getChildren().put(currentbit, node);
            }
            current = current.getChildren().get(currentbit);
        }
        current.isFinished = true;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int ans = solve(nums);

        System.out.println(ans);
    }
}
