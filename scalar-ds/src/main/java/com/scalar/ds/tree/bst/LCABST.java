package com.scalar.ds.tree.bst;

import com.scalar.ds.common.TreeNode;

/**
 * @author t0k02w6 on 27/06/22
 * @project scalar
 */
public class LCABST {
    private static TreeNode lca(TreeNode root, int p, int q) {
        if(root == null)
            return null;
        if(root.val < p && root.val < q)
            return lca(root.right, p, q);
        if(root.val > p && root.val > q)
            return lca(root.left, p, q);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.left.right.right = new TreeNode(7);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(18);
        root.right.right.left = new TreeNode(16);
        root.right.right.right = new TreeNode(20);

        TreeNode lcaNode = lca(root, 7, 16);
        System.out.println(lcaNode.val);

    }
}
