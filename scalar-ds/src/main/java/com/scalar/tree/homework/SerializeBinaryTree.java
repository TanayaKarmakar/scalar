package com.scalar.tree.homework;

import com.scalar.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author t0k02w6 on 23/06/22
 * @project scalar
 */
public class SerializeBinaryTree {
    private static ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(A);

        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            result.add(node.val);

            if(node.val == -1)
                continue;
            if(node.left == null) {
                q.add(new TreeNode(-1));
            } else {
                q.add(node.left);
            }

            if(node.right == null) {
                q.add(new TreeNode(-1));
            } else {
                q.add(node.right);
            }
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
