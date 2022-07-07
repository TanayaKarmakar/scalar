package com.scalar.ds.tree;

import com.scalar.ds.common.TreeNode;

/**
 * @author t0k02w6 on 30/06/22
 * @project scalar
 */
public class HeightBalancedTree {
    private static boolean isBalanced(TreeNode root) {
        int height = checkBalanace(root);
        if(height == -1)
            return false;
        return true;
    }

    private static int checkBalanace(TreeNode root) {
        if(root == null)
            return 0;
        int l = checkBalanace(root.left);
        if(l == -1)
            return -1;
        int r = checkBalanace(root.right);
        if(r == -1)
            return -1;
        int diff = Math.abs(l - r);
        if(diff > 1)
            return -1;
        return 1 + Integer.max(l, r);
    }

    public static void main(String[] args) {

    }
}
