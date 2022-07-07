package com.scalar.ds.tree.assignment;

import com.scalar.ds.common.TreeNode;

import java.util.ArrayList;

/**
 * @author t0k02w6 on 26/02/22
 * @project scalar-ds
 */
public class InOrderTraversal {
    private static void inorderTraversal(TreeNode root, ArrayList<Integer> values) {
        if(root == null)
            return;
        inorderTraversal(root.left, values);
        values.add(root.val);
        inorderTraversal(root.right, values);
    }

    public static ArrayList<Integer> inorderTraversal(TreeNode A) {
        ArrayList<Integer> values = new ArrayList<>();
        inorderTraversal(A, values);
        return values;
    }

    public static void main(String[] args) {

    }
}
