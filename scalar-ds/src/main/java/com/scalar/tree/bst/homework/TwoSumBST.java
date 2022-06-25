package com.scalar.tree.bst.homework;

import com.scalar.common.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author t0k02w6 on 25/06/22
 * @project scalar
 */
public class TwoSumBST {
    private static int t2Sum(TreeNode A, int B) {
        Set<Integer> set = new HashSet<>();
        boolean ifPossible = t2SumRec(A, B, set);
        return ifPossible ? 1: 0;
    }

    private static boolean t2SumRec(TreeNode root, int target, Set<Integer> set) {
        if(root == null)
            return false;
        if(set.contains(target - root.val))
            return true;
        set.add(root.val);
        boolean l = t2SumRec(root.left, target, set);
        boolean r = t2SumRec(root.right, target, set);
        return l || r;
    }

    public static void main(String[] args) {

    }
}
