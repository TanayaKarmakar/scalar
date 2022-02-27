package com.scalar.tree.assignment;

import com.scalar.common.TreeNode;

/**
 * @author t0k02w6 on 27/02/22
 * @project scalar-ds
 */
public class BSTNodesInRange {
    private static int count = 0;

    private static void solveRec(TreeNode A, int B, int C) {
        if(A == null)
            return;
        if(A.val >= B && A.val <= C) {
            count++;
            solveRec(A.left, B, C);
            solveRec(A.right, B, C);
        }
        else if(A.val < B)
            solveRec(A.right, B, C);
        else
            solveRec(A.left, B, C);
    }

    private static int solve(TreeNode A, int B, int C) {
        count = 0;
        solveRec(A, B, C);
        return count;
    }

    public static void main(String[] args) {

    }
}
