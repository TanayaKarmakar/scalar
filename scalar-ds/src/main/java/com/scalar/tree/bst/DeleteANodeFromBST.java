package com.scalar.tree.bst;

import com.scalar.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author t0k02w6 on 24/06/22
 * @project scalar
 */
public class DeleteANodeFromBST {
    private static TreeNode getMax(TreeNode root) {
        TreeNode temp = root;
        while(temp != null) {
            temp = temp.right;
        }
        return temp;
    }

    private static TreeNode deleteVal(TreeNode root, int k) {
        TreeNode temp = root;
        while(temp.right.val != k) {
            temp = temp.right;
        }
        temp.right = null;
        return root;
    }

    private static TreeNode deleteNode(TreeNode root, int k) {
        if(root == null)
            return null;
        if(root.val > k)
            root.left = deleteNode(root.left, k);
        else if(root.val < k)
            root.right = deleteNode(root.right, k);
        else {
            if(root.left == null && root.right == null)
                return null;
            else if(root.left == null)
                return root.right;
            else if(root.right == null)
                return root.left;
            else {
                TreeNode maxNode = getMax(root.left);
                root.val = maxNode.val;
                root.left = deleteVal(root.left, maxNode.val);
            }
        }
        return root;
    }

    private static void levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            System.out.println(node.val);

            if(node.left != null)
                q.add(node.left);
            if(node.right != null)
                q.add(node.right);
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);
        root.left.right.right = new TreeNode(8);

        deleteNode(root, 8);
        levelOrder(root);
    }
}
