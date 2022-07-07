package com.scalar.ds.tree.bst.assignment;

import com.scalar.ds.common.TreeNode;

/**
 * @author t0k02w6 on 25/06/22
 * @project scalar
 */
public class LowestCommonAncestor {
    private static TreeNode lcaRec(TreeNode root, int p, int q) {
        if(root == null)
            return null;
        if(root.val == p || root.val == q)
            return root;
        TreeNode left = lcaRec(root.left, p, q);
        TreeNode right = lcaRec(root.right, p, q);
        if(left != null && right != null)
            return root;
        else if(left != null)
            return left;
        else
            return right;
    }

    private static boolean find(TreeNode root, int val) {
        if(root == null)
            return false;
        if(root.val == val)
            return true;
        return find(root.left, val) || find(root.right, val);
    }


    public static int lca(TreeNode A, int B, int C) {
        if(A == null)
            return -1;
        if(!find(A, B) || !find(A, C))
            return -1;
        TreeNode lcaNode = lcaRec(A, B, C);
        if(lcaNode == null)
            return -1;
        return lcaNode.val;
    }

    public static void main(String[] args) {

    }
}
