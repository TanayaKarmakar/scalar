package com.scalar.ds.trie.homework;

import com.scalar.ds.common.TreeNode;

/**
 * @author t0k02w6 on 09/07/22
 * @project scalar
 */
public class BinaryTreeToDLL {
    private static TreeNode prev = null;
    private static TreeNode head = null;

    private static TreeNode dllRec(TreeNode root) {
        if(root == null)
            return null;
        root.left = dllRec(root.left);
        if(prev == null) {
            head = root;
        } else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        dllRec(root.right);
        return root;
    }


    private static TreeNode solve (TreeNode root) {
        if(root == null)
            return null;
        head = null;
        prev = null;
        dllRec(root);

        TreeNode temp = head;
        while(temp.right != null) {
            //System.out.println(temp.val);
            temp = temp.right;
        }

        temp.right = head;
        head.left = temp;

        return head;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        solve(root);
    }
}
