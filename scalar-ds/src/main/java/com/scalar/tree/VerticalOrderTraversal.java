package com.scalar.tree;

import com.scalar.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author t0k02w6 on 23/06/22
 * @project scalar
 */
public class VerticalOrderTraversal {
    private static List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        verticalTraversalRec(root, map, 0);
        List<List<Integer>> result = new ArrayList<>();
        for(Map.Entry<Integer, List<Integer>> entry: map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }

    private static void verticalTraversalRec(TreeNode root, TreeMap<Integer, List<Integer>> map, int level) {
        if(root == null)
            return;
        if(!map.containsKey(level))
            map.put(level, new ArrayList<>());
        map.get(level).add(root.val);
        verticalTraversalRec(root.left, map, level - 1);
        verticalTraversalRec(root.right, map, level + 1);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(9);
        root.left = new TreeNode(6);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(5);
        root.left.left.left.right = new TreeNode(14);
        root.left.right.left = new TreeNode(11);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(1);
        root.right.right.left = new TreeNode(12);

        List<List<Integer>> result = verticalTraversal(root);

        for(List<Integer> level: result) {
            System.out.println(level);
        }
    }
}
