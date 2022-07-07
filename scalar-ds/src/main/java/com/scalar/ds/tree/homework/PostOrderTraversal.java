package com.scalar.ds.tree.homework;

import com.scalar.ds.common.TreeNode;

import java.util.ArrayList;

/**
 * @author t0k02w6 on 22/06/22
 * @project scalar
 */
public class PostOrderTraversal {
    private static void postorderTraversal(TreeNode root, ArrayList<Integer> result) {
        if(root == null)
            return;
        postorderTraversal(root.left, result);
        postorderTraversal(root.right, result);
        result.add(root.val);
    }

    public ArrayList<Integer> postorderTraversal(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        postorderTraversal(A, result);
        return result;
    }

    public static void main(String[] args) {

    }
}
