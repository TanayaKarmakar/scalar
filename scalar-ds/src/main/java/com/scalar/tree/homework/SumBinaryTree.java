package com.scalar.tree.homework;

import com.scalar.common.TreeNode;

/**
 * @author t0k02w6 on 30/06/22
 * @project scalar
 */
public class SumBinaryTree {
    static class TreeInfo {
        int nodeSum;

        public TreeInfo(int nodeSum) {
            this.nodeSum = nodeSum;
        }
    }

    private static TreeInfo sumRec(TreeNode root) {
        if(root == null)
            return new TreeInfo(0);
        TreeInfo leftInfo = sumRec(root.left);
        if(leftInfo.nodeSum == Integer.MAX_VALUE)
            return leftInfo;
        TreeInfo rightInfo = sumRec(root.right);
        if(rightInfo.nodeSum == Integer.MAX_VALUE)
            return rightInfo;
        if(leftInfo.nodeSum + rightInfo.nodeSum != root.val && (leftInfo.nodeSum != 0 || rightInfo.nodeSum != 0))
            return new TreeInfo(Integer.MAX_VALUE);
        return new TreeInfo(leftInfo.nodeSum + rightInfo.nodeSum + root.val);
    }

    private static int solve(TreeNode A) {
        TreeInfo treeInfo = sumRec(A);
        return treeInfo.nodeSum == Integer.MAX_VALUE ? 0: 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(6);
//        root.right.right = new TreeNode(3);

        int ans = solve(root);

        System.out.println(ans);
    }
}
