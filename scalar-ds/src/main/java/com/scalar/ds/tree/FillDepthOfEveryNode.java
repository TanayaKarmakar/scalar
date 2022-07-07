package com.scalar.ds.tree;


import com.scalar.ds.common.TreeNode;

/**
 * @author t0k02w6 on 22/06/22
 * @project scalar
 */
public class FillDepthOfEveryNode {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        int depth;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private static void fillDepth(TreeNode root) {
        root.depth = 0;
        fillDepthRec(root, 0);
    }

    private static void fillDepthRec(TreeNode root, int currentDepth) {
        if(root == null)
            return;
        root.depth = currentDepth;
        fillDepthRec(root.left, currentDepth + 1);
        fillDepthRec(root.right, currentDepth + 1);
    }

    private static void traverse(TreeNode root) {
        if(root == null)
            return;
        System.out.println("Val - " + root.val + ": Depth - " + root.depth);
        traverse(root.left);
        traverse(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(12);
        root.left.right = new TreeNode(15);
        root.right.left = new TreeNode(20);
        fillDepth(root);
        traverse(root);
    }
}
