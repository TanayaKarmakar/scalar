package com.scalar.tree.bst;

import com.scalar.common.TreeNode;

/**
 * @author t0k02w6 on 23/06/22
 * @project scalar
 */
public class SearchInABST {
    private static boolean searchKey(TreeNode root, int k) {
        if(root == null)
            return false;
        if(root.val == k)
            return true;
        if(root.val > k)
            return searchKey(root.left, k);
        else
            return searchKey(root.right, k);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);
        root.left.right.right = new TreeNode(8);

        boolean isFound = searchKey(root, 7);
        System.out.println(isFound);

        isFound = searchKey(root, 19);
        System.out.println(isFound);
    }
}
