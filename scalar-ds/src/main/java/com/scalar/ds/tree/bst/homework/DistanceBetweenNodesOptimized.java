package com.scalar.ds.tree.bst.homework;

import com.scalar.ds.common.TreeNode;

/**
 * @author t0k02w6 on 26/06/22
 * @project scalar
 */
public class DistanceBetweenNodesOptimized {
    private static TreeNode findLCA(TreeNode root, int p, int q) {
        if(root == null)
            return null;
        if(root.val == p || root.val == q)
            return root;
        TreeNode left = findLCA(root.left, p, q);
        TreeNode right = findLCA(root.right, p, q);
        if(left != null && right != null)
            return root;
        else if(left != null)
            return left;
        else
            return right;
    }

    private static int distanceFromLca(TreeNode root, int target) {
        if(root.val == target)
            return 0;
        if(root.val > target)
            return 1 + distanceFromLca(root.left, target);
        else
            return 1 + distanceFromLca(root.right, target);
    }

    private static int solve(TreeNode A, int B, int C) {
        if(B > C) {
            int tmp = B;
            B = C;
            C = tmp;
        }
        TreeNode lcaNode = findLCA(A, B, C);
        return distanceFromLca(lcaNode, B) + distanceFromLca(lcaNode, C);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(11);

        int B = 2;
        int C = 11;
        int ans = solve(root, B, C);

        System.out.println(ans);
    }
}
