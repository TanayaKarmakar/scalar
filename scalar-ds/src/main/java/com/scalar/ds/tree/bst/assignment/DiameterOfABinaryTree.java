package com.scalar.ds.tree.bst.assignment;

import com.scalar.ds.common.TreeNode;

/**
 * @author t0k02w6 on 25/06/22
 * @project scalar
 */
public class DiameterOfABinaryTree {

    private static int diameterRec(TreeNode root, int[] maxi) {
        if(root == null)
            return 0;
        int lh = diameterRec(root.left, maxi);
        int rh = diameterRec(root.right, maxi);
        maxi[0] = Integer.max(maxi[0], lh + rh);
        return 1 + Integer.max(lh, rh);
    }

    private static int solve(TreeNode A) {
        int[] diameter = new int[1];
        diameterRec(A, diameter);
        return diameter[0];
    }

    public static void main(String[] args) {

    }
}
