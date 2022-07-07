package com.scalar.ds.tree;

import com.scalar.ds.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author t0k02w6 on 23/06/22
 * @project scalar
 */
public class LeftViewOfBinaryTree {
    private static void leftView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if(i == 0) {
                    System.out.println(node.val);
                }
                if(node.left != null)
                    q.add(node.left);
                if(node.right != null)
                    q.add(node.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(9);
        root.left = new TreeNode(6);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(1);
        root.left.right.left = new TreeNode(2);
        root.left.right.right = new TreeNode(10);

        leftView(root);
    }
}
