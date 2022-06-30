package com.scalar.tree;

import com.scalar.common.TreeNode;


/**
 * @author t0k02w6 on 29/06/22
 * @project scalar
 */
public class MorrisInorderTraversal {
    private static void inorder(TreeNode root) {
        TreeNode curr = root;

        while(curr != null) {
            if(curr.left == null) {
                System.out.print(curr.val + " ");
                curr = curr.right;
            } else {
                TreeNode pre = curr.left;
                while(pre.right != null && pre.right != curr)
                    pre = pre.right;
                if(pre.right == null) {
                    pre.right = curr;
                    curr = curr.left;
                } else {
                    pre.right = null;
                    System.out.print(curr.val + " ");
                    curr = curr.right;
                }
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.left.left.right = new TreeNode(3);
        root.right.right = new TreeNode(35);

        inorder(root);
    }
}
