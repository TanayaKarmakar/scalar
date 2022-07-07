package com.scalar.ds.tree.assignment;

import com.scalar.ds.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author t0k02w6 on 22/06/22
 * @project scalar
 */
public class LevelOrderTraversal {
    private static ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.add(A);
        while(!q.isEmpty()) {
            int size = q.size();
            ArrayList<Integer> row = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                row.add(node.val);

                if(node.left != null)
                    q.add(node.left);
                if(node.right != null)
                    q.add(node.right);
            }
            result.add(row);
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
