package com.scalar.ds.tree.homework;

import com.scalar.ds.common.TreeNode;

import java.util.ArrayList;

/**
 * @author t0k02w6 on 22/06/22
 * @project scalar
 */
public class PreorderTraversal {
    private static void preorderTraversal(TreeNode root, ArrayList<Integer> result) {
        if(root == null)
            return;
        result.add(root.val);
        preorderTraversal(root.left, result);
        preorderTraversal(root.right, result);
    }

    private static ArrayList<Integer> preorderTraversal(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        preorderTraversal(A, result);
        return result;
    }

    public static void main(String[] args) {

    }
}
