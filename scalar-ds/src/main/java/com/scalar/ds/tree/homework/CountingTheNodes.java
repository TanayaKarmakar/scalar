package com.scalar.ds.tree.homework;

import com.scalar.ds.common.TreeNode;

/**
 * @author t0k02w6 on 26/02/22
 * @project scalar-ds
 */
public class CountingTheNodes {
//    private static void populate(TreeNode parent, TreeNode root, Map<TreeNode, TreeNode> map) {
//        if(root == null)
//            return;
//        map.put(root, parent);
//        populate(root, root.left, map);
//        populate(root, root.right, map);
//    }

    private static int count = 0;

    private static void countRec(TreeNode root, int prevMax) {
        if(root == null)
            return;
        if(root.val > prevMax) {
            prevMax = root.val;
            count++;
        }
        countRec(root.left, prevMax);
        countRec(root.right, prevMax);
    }

    private static int solve(TreeNode A) {
        if(A == null)
            return 0;
        countRec(A, Integer.MIN_VALUE);
        return count;
    }

    public static void main(String[] args) {

    }
}
