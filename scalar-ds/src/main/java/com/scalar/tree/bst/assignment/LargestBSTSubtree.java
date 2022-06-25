package com.scalar.tree.bst.assignment;

import com.scalar.common.TreeNode;

/**
 * @author t0k02w6 on 24/06/22
 * @project scalar
 */
public class LargestBSTSubtree {
    private static TreeNode tempNode = null;
    private static int maxSize = 0;

    private static int size(TreeNode root) {
        if(root == null)
            return 0;
        return 1 + size(root.left) + size(root.right);
    }

    private static boolean isValidBST(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) {
            return true;
        }
        boolean l = isValidBST(root.left);
        boolean r = isValidBST(root.right);

        if(!l || !r)
            return false;
        else {
            if(root != null) {
                if(root.left != null && root.val < root.left.val)
                    return false;
                if(root.right != null && root.val > root.right.val)
                    return false;
                int currentSize = size(root);
                if(currentSize > maxSize)
                    maxSize = currentSize;
            }
            return true;
        }
    }

    public static int solve(TreeNode A) {
        isValidBST(A);
        return maxSize;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(8);
        root.right.right = new TreeNode(7);

        int ans = solve(root);

        System.out.println(ans);
    }
}
