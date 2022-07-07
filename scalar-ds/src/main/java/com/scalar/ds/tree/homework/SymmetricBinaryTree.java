package com.scalar.ds.tree.homework;

import com.scalar.ds.common.TreeNode;

/**
 * @author t0k02w6 on 30/06/22
 * @project scalar
 */
public class SymmetricBinaryTree {
    private static int isSymmetric(TreeNode A) {
        if(A == null)
            return 0;
        TreeNode left = A.left;
        TreeNode right = A.right;
        boolean isEqual = isSymmetricRec(left, right);
        return isEqual ? 1: 0;
    }

    private static boolean isSymmetricRec(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null)
            return true;
        if(root1 == null || root2 == null)
            return false;
        return root1.val == root2.val && isSymmetricRec(root1.left, root2.right)
                && isSymmetricRec(root1.right, root2.left);
    }

    public static void main(String[] args) {

    }
}
