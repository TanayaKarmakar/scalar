package com.scalar.ds.tree.homework;

import com.scalar.ds.common.TreeNode;

/**
 * @author t0k02w6 on 27/02/22
 * @project scalar-ds
 */
public class InvertABinaryTree {
    private static void invertRec(TreeNode root) {
        if((root == null) || (root.left == null && root.right == null))
            return;
        invertRec(root.left);
        invertRec(root.right);
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }

    private static TreeNode invertTree(TreeNode A) {
        invertRec(A);
        return A;
    }

    public static void main(String[] args) {

    }
}
