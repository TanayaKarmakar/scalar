package com.scalar.ds.tree.homework;

import com.scalar.ds.common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 27/02/22
 * @project scalar-ds
 */
public class PathToGivenNode {
    private static void populate(TreeNode root, TreeNode parent, Map<Integer,Integer> map) {
        if(root == null)
            return;
        map.put(root.val, parent == null ? Integer.MAX_VALUE: parent.val);
        populate(root.left, root, map);
        populate(root.right, root, map);
    }

    private static ArrayList<Integer> solve(TreeNode A, int B) {
        Map<Integer, Integer> map = new HashMap<>();
        populate(A, null, map);
        ArrayList<Integer> result = new ArrayList<>();
        int val = B;
        while(val != Integer.MAX_VALUE) {
            result.add(0, val);
            val = map.get(val);
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
