package com.scalar.tree.assignment;

import com.scalar.common.TreeNode;

import java.util.Stack;

/**
 * @author t0k02w6 on 30/06/22
 * @project scalar
 */
public class KthSmallest {
    private static int kthsmallest(TreeNode A, int B) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(A);

        A = A.left;
        while(!stack.isEmpty() || A!= null) {
            while(A != null) {
                stack.push(A);
                A = A.left;
            }

            A = stack.pop();
            B--;
            if(B == 0)
                return A.val;
            A = A.right;
        }

        B--;
        if(B== 0)
            return stack.pop().val;
        return -1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(2);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(3);

        int ans = kthsmallest(root, 2);
        System.out.println(ans);
    }
}
