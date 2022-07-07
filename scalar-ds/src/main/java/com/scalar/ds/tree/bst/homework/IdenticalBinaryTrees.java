package com.scalar.ds.tree.bst.homework;

import com.scalar.ds.common.TreeNode;

/**
 * @author t0k02w6 on 25/06/22
 * @project scalar
 */
public class IdenticalBinaryTrees {
    private static int isSameTree(TreeNode A, TreeNode B) {
        boolean isEqual = sameTreeRec(A, B);
        return isEqual ? 1: 0;
    }

    private static boolean sameTreeRec(TreeNode a, TreeNode b) {
        if(a == null && b == null)
            return true;
        if(a == null || b == null)
            return false;
        return a.val == b.val && sameTreeRec(a.left, b.left)
                && sameTreeRec(a.right, b.right);
    }

    public static void main(String[] args) {

    }
}
