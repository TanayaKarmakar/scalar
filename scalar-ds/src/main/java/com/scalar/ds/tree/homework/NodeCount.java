package com.scalar.ds.tree.homework;

import com.scalar.ds.common.TreeNode;

/**
 * @author t0k02w6 on 26/02/22
 * @project scalar-ds
 */
public class NodeCount {
    private static int solve(TreeNode A) {
        if(A == null)
            return 0;
        return 1 + solve(A.left) + solve(A.right);
    }

    public static void main(String[] args) {

    }
}
