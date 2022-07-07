package com.scalar.ds.tree.bst.assignment;

import com.scalar.ds.common.TreeNode;

/**
 * @author t0k02w6 on 24/06/22
 * @project scalar
 */
public class SortedArrayToBalancedBST {
    private static TreeNode sortedArrayToBST(int[] A, int start, int end) {
        if(start > end)
            return null;
        int mid = (start + end) >> 1;
        TreeNode root = new TreeNode(A[mid]);
        root.left = sortedArrayToBST(A, start, mid - 1);
        root.right = sortedArrayToBST(A, mid + 1, end);
        return root;
    }

    private static TreeNode sortedArrayToBST(final int[] A) {
        return sortedArrayToBST(A, 0, A.length - 1);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 5, 10};
    }
}
