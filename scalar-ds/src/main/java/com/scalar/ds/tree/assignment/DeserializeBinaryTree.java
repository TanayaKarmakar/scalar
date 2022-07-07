package com.scalar.ds.tree.assignment;

import com.scalar.ds.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author t0k02w6 on 22/06/22
 * @project scalar
 */
public class DeserializeBinaryTree {
    private static TreeNode solve(ArrayList<Integer> A) {
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(A.get(0));
        q.add(root);

        int i = 1;
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if(node == null)
                continue;
            int left = A.get(i);
            int right = A.get(i + 1);
            i += 2;

            if(left != -1) {
                node.left = new TreeNode(left);
            }

            if(right != -1) {
                node.right = new TreeNode(right);
            }

            q.add(node.left);
            q.add(node.right);
        }

        return root;
    }

    public static void main(String[] args) {

    }
}
