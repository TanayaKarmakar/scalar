package com.scalar.tree.assignment;

import com.scalar.common.TreeNode;

import java.util.ArrayList;

/**
 * @author t0k02w6 on 26/02/22
 * @project scalar-ds
 */
public class PreOrderTraversal {
    private static void preorderTraversal(TreeNode root, ArrayList<Integer> values) {
        if(root == null)
            return;
        values.add(root.val);
        preorderTraversal(root.left, values);
        preorderTraversal(root.right, values);
    }

    private static ArrayList<Integer> preorderTraversal(TreeNode A) {
        ArrayList<Integer> values = new ArrayList<>();
        preorderTraversal(A, values);
        return values;
    }

    public static void main(String[] args) {

    }
}
