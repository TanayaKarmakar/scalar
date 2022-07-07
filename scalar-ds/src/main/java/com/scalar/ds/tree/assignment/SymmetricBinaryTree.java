package com.scalar.ds.tree.assignment;

import com.scalar.ds.common.TreeNode;

/**
 * @author t0k02w6 on 27/02/22
 * @project scalar-ds
 */
public class SymmetricBinaryTree {
    private static boolean isSymmetricRec(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null)
            return true;
        if(root1 == null || root2 == null)
            return false;
        return root1.val == root2.val && isSymmetricRec(root1.left, root2.right) &&
                isSymmetricRec(root1.right, root2.left);
    }

    private static int isSymmetric(TreeNode A) {
        if(A == null)
            return 1;
        boolean ans = isSymmetricRec(A.left, A.right);
        return ans ? 1: 0;
    }

    public static void main(String[] args) {

    }
}
