package com.scalar.tree.homework;

import com.scalar.common.TreeNode;

/**
 * @author t0k02w6 on 30/06/22
 * @project scalar
 */
public class PathSum {
    private static int hasPathSum(TreeNode A, int B) {
        if(A == null)
            return 0;
        int ans = 0;
        int subSum = B - A.val;
        if(subSum == 0 && A.left == null && A.right == null)
            return 1;
        if(A.left != null)
            ans = ans | hasPathSum(A.left, subSum);
        if(A.right != null)
            ans = ans | hasPathSum(A.right, subSum);
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1000);
        root.right = new TreeNode(200);

        int B = 1000;
        int ans = hasPathSum(root, B);

        System.out.println(ans);
    }
}
