package com.scalar.tree.assignment;

import com.scalar.common.TreeNode;

/**
 * @author t0k02w6 on 26/02/22
 * @project scalar-ds
 */
public class TreeHeight {
    private static int solve(TreeNode A) {
        if(A == null)
            return 0;
        int left = solve(A.left);
        int right = solve(A.right);
        return 1 + Integer.max(left, right);
    }

    public static void main(String[] args) {

    }
}
