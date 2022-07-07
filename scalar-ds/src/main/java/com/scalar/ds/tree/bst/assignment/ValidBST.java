package com.scalar.ds.tree.bst.assignment;

import com.scalar.ds.common.TreeNode;

/**
 * @author t0k02w6 on 24/06/22
 * @project scalar
 */
public class ValidBST {
    private static boolean isValidBST(TreeNode root, long min, long max) {
        if(root == null)
            return true;
        if(root.val <= min || root.val >= max)
            return false;
        boolean l = isValidBST(root.left, min, root.val);
        boolean r = isValidBST(root.right, root.val, max);
        return l && r;
    }

    private static int isValidBST(TreeNode A) {
        boolean isValid = isValidBST(A, Long.MIN_VALUE, Long.MAX_VALUE);
        return isValid ? 1: 0;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.left.right = new TreeNode(5);

        int ans = isValidBST(root);
        System.out.println(ans);
    }
}
