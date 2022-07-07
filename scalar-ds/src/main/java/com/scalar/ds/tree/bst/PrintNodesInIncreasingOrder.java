package com.scalar.ds.tree.bst;

import com.scalar.ds.common.TreeNode;

/**
 * @author t0k02w6 on 25/06/22
 * @project scalar
 */
public class PrintNodesInIncreasingOrder {
    private static void printBST(TreeNode root) {
        if(root != null) {
            printBST(root.left);
            System.out.println(root.val);
            printBST(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(7);
        root.left.left.left = new TreeNode(1);
        root.left.left.right = new TreeNode(4);
        root.left.left.right.left = new TreeNode(3);
        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(8);
        root.right.right = new TreeNode(22);
        root.right.right.left = new TreeNode(21);
        root.right.right.right = new TreeNode(50);

        printBST(root);
    }
}
