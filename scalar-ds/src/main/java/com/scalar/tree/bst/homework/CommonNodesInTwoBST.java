package com.scalar.tree.bst.homework;

import com.scalar.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author t0k02w6 on 25/06/22
 * @project scalar
 */
public class CommonNodesInTwoBST {
    private static void getNodes(TreeNode root, List<Integer> nodeList) {
        if(root == null)
            return;
        getNodes(root.left, nodeList);
        nodeList.add(root.val);
        getNodes(root.right, nodeList);
    }

    public static int solve(TreeNode A, TreeNode B) {
        List<Integer> nodeA = new ArrayList<>();
        List<Integer> nodeB = new ArrayList<>();
        getNodes(A, nodeA);
        getNodes(B, nodeB);

        List<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i < nodeA.size() && j < nodeB.size()) {
            if(nodeA.get(i) == nodeB.get(j)) {
                result.add(nodeA.get(i));
                i++;
                j++;
            } else if(nodeA.get(i) < nodeB.get(j)) {
                i++;
            } else {
                j++;
            }
        }

        long sum = 0;
        int mod = 1000000007;
        for(Integer el: result) {
            sum += el;
        }

        return (int) (sum % mod);
    }

    public static void main(String[] args) {

    }
}
