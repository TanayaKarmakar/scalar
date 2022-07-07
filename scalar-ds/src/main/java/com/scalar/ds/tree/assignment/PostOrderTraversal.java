package com.scalar.ds.tree.assignment;

import com.scalar.ds.common.TreeNode;

import java.util.ArrayList;

/**
 * @author t0k02w6 on 26/02/22
 * @project scalar-ds
 */
public class PostOrderTraversal {
    private static void postorderTraversal(TreeNode root, ArrayList<Integer> values) {
        if(root == null)
            return;
        postorderTraversal(root.left, values);
        postorderTraversal(root.right, values);
        values.add(root.val);
    }

    private static ArrayList<Integer> postorderTraversal(TreeNode A) {
        ArrayList<Integer> values = new ArrayList<>();
        postorderTraversal(A, values);
        return values;
    }

    public static void main(String[] args) {

    }
}
