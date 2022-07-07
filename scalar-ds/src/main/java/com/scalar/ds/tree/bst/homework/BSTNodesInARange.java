package com.scalar.ds.tree.bst.homework;

import com.scalar.ds.common.TreeNode;

/**
 * @author t0k02w6 on 25/06/22
 * @project scalar
 */
public class BSTNodesInARange {
    private static int count = 0;

    private static int solve(TreeNode A, int B, int C) {
        count = 0;
        solveRec(A, B, C);
        return count;
    }

    private static void solveRec(TreeNode root, int b, int c) {
        if(root == null)
            return;
        if(root.val > c)
            solveRec(root.left, b, c);
        else if(root.val < b)
            solveRec(root.right, b, c);
        else {
            count++;
            solveRec(root.left, b, c);
            solveRec(root.right, b, c);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(15);
        root.left = new TreeNode(12);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(14);
        root.right.left = new TreeNode(16);
        root.right.right = new TreeNode(27);
        root.left.left.left = new TreeNode(8);

        int min = 12;
        int max = 20;

        int count = solve(root, min, max);

        System.out.println(count);
    }
}
