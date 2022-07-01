package com.scalar.tree.assignment;

import com.scalar.common.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author t0k02w6 on 30/06/22
 * @project scalar
 */
public class EqualTreePartition {
    private static int solve(TreeNode A) {
        Set<Long> sumSet = new HashSet<>();
        long sum = sumRec(A, sumSet);
        if(sum % 2 != 0)
            return 0;
        return sumSet.contains(sum / 2) ? 1: 0;
    }

    private static long sumRec(TreeNode root, Set<Long> sumSet) {
        if(root == null)
            return 0;
        long sum = root.val + sumRec(root.left, sumSet) + sumRec(root.right, sumSet);
        sumSet.add(sum);
        return sum;
    }


    public static void main(String[] args) {

    }
}
