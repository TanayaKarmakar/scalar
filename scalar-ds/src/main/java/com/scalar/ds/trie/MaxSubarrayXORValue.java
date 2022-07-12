package com.scalar.ds.trie;

/**
 * @author t0k02w6 on 04/07/22
 * @project scalar
 */
public class MaxSubarrayXORValue {
    private static int solve(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];

        int pre = 0;
        for(int i = 0; i < nums.length; i++) {
            prefix[i] = pre ^ nums[i];
            pre = prefix[i];
        }

        TrieNodeGenerics<Integer> root = new TrieNodeGenerics<>();
        for(int el: prefix) {
            insertElements(root, el);
        }

        int maxXor = 0;
        for(int el: prefix) {
            int item = numberForWhichMaxXor(root, el);
            maxXor = Integer.max(maxXor, item ^ el);
        }
        return maxXor;
    }

    private static int numberForWhichMaxXor(TrieNodeGenerics<Integer> root, int el) {
        TrieNodeGenerics<Integer> current = root;
        int result = 0;
        for(int i = 31; i >= 0; i--) {
            int currentRotation = (el >> i);
            int currentBit = (currentRotation & 1);
            int searchBit = 1 - currentBit;
            int acceptedBit = 0;
            if(current.getChildren().containsKey(searchBit)) {
                acceptedBit = searchBit;
            } else {
                acceptedBit = currentBit;
            }
            current = current.getChildren().get(acceptedBit);
            result = (result << 1);
            result += acceptedBit;
        }
        return result;
    }

    private static void insertElements(TrieNodeGenerics<Integer> root, int el) {
        TrieNodeGenerics<Integer> current = root;
        for(int i = 31; i >= 0; i--) {
            int currentRotation = (el >> i);
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
        int[] nums = {4,2,2,6,4};
        int ans = solve(nums);

        System.out.println(ans);
    }
}
