package com.scalar.ds.trie;

import java.util.Arrays;

/**
 * @author t0k02w6 on 03/07/22
 * @project scalar
 */
public class MaximumValueOfXorOfPairs {
    private static int[] maximumZor(int[] nums) {
        TrieNodeGenerics<Integer> root = new TrieNodeGenerics<>();
        for(int i = 0; i < nums.length; i++) {
            insertNumber(root, nums[i]);
        }

        int[] result = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            result[i] = findPair(root, nums[i]);
        }
        return result;
    }

    private static int findPair(TrieNodeGenerics<Integer> root, int num) {
        int result = 0;
        int j = 0;
        TrieNodeGenerics<Integer> current = root;
        for(int i = 31; i >= 0; i--) {
            int currentRotation = num >> i;
            int currentBit = (currentRotation & 1);
            int currentBitToBeSearched = 1 - currentBit;
            int acceptedBit = 0;
            if(current.getChildren().containsKey(currentBitToBeSearched)) {
                acceptedBit = currentBitToBeSearched;
            } else {
                acceptedBit = currentBit;
            }
            current = current.getChildren().get(acceptedBit);
            result = (result << 1);
            result += acceptedBit;
        }
        return result;
    }

    private static void insertNumber(TrieNodeGenerics<Integer> root, int num) {
        TrieNodeGenerics<Integer> current = root;
        for(int i = 31; i >= 0; i--) {
            int currentRotation = num >> i;
            int currentBit = (currentRotation & 1);
            if(!current.getChildren().containsKey(currentBit)) {
                TrieNodeGenerics<Integer> newNode = new TrieNodeGenerics<>();
                current.getChildren().put(currentBit, newNode);
            }
            current = current.getChildren().get(currentBit);
        }
        current.isFinished = true;
    }

    public static void main(String[] args) {
        int[] nums = {10, 20,25,5,30};
        int[] res = maximumZor(nums);

        System.out.println(Arrays.toString(res));
    }
}
