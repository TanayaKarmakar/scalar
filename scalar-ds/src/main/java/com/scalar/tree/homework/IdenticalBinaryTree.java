package com.scalar.tree.homework;

import com.scalar.common.TreeNode;

/**
 * @author t0k02w6 on 26/02/22
 * @project scalar-ds
 */
public class IdenticalBinaryTree {
    private static boolean isSameTreeRec(TreeNode A, TreeNode B) {
        if(A == null && B == null)
            return true;
        if(A == null || B == null)
            return false;
        return A.val == B.val && isSameTreeRec(A.left, B.left)
                && isSameTreeRec(A.right, B.right);
    }

    private static int isSameTree(TreeNode A, TreeNode B) {
        boolean ans = isSameTreeRec(A, B);
        return ans ? 1: 0;
    }

    public static void main(String[] args) {

    }
}
