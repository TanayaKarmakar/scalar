package com.scalar.tree.bst;

import com.scalar.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author t0k02w6 on 23/06/22
 * @project scalar
 */
public class InsertANodeToTheBST {
    private static TreeNode insertNode(TreeNode root, int k) {
        if (root == null) {
            return new TreeNode(k);
        }
        if (root.val >= k)
            root.left = insertNode(root.left, k);
        else
            root.right = insertNode(root.right, k);
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

        insertNode(root, 4);

        levelOrder(root);
    }
}
