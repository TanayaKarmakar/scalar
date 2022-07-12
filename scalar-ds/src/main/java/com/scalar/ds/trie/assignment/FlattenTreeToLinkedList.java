package com.scalar.ds.trie.assignment;

import com.scalar.ds.common.TreeNode;

/**
 * @author t0k02w6 on 09/07/22
 * @project scalar
 */
public class FlattenTreeToLinkedList {
    public static TreeNode flatten(TreeNode a) {
        if(a == null)
            return null;
        a.left = flatten(a.left);
        a.right = flatten(a.right);
        TreeNode left = a.left;
        TreeNode right = a.right;
        if(left != null) {
            a.right = left;
            a.left = null;
            TreeNode temp = a;
            while(temp.right != null) {
                temp = temp.right;
            }
            temp.right = right;
        }

        return a;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        root = flatten(root);

        TreeNode temp = root;
        while(temp != null) {
            System.out.println(temp.val);
            temp = temp.right;
        }

    }
}
