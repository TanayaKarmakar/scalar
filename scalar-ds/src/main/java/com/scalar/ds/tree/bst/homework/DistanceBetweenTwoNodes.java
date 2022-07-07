package com.scalar.ds.tree.bst.homework;

import com.scalar.ds.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 26/06/22
 * @project scalar
 */
public class DistanceBetweenTwoNodes {
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

    private static void populateNodes(Map<Integer, TreeNode> map, TreeNode root, TreeNode parent) {
        if(root != null) {
            map.put(root.val, parent);
            populateNodes(map, root.left, root);
            populateNodes(map, root.right, root);
        }
    }

    private static int solve(TreeNode A, int B, int C) {
        Map<Integer, TreeNode> map = new HashMap<>();
        populateNodes(map, A, null);
        TreeNode lcaNode = findLCA(A, B, C);
        int count = 0;
        if(lcaNode.val == B) {
            int start = C;
            while(start != lcaNode.val) {
                count++;
                start = map.get(start).val;
            }
        } else if(lcaNode.val == C) {
            int start = B;
            while(start != lcaNode.val) {
                count++;
                start = map.get(start).val;
            }
        } else {
            int start = B;
            while(start != lcaNode.val) {
                count++;
                start = map.get(start).val;
            }

            start = C;
            while(start != lcaNode.val) {
                count++;
                start = map.get(start).val;
            }
        }
        return count;
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
