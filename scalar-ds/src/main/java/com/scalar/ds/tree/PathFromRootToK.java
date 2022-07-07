package com.scalar.ds.tree;

import com.scalar.ds.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 22/06/22
 * @project scalar
 */
public class PathFromRootToK {
    private static void path(TreeNode root, TreeNode nodeK) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        populateNode(root, null, map);

        System.out.println(nodeK.val);
        TreeNode temp = nodeK;
        while(map.containsKey(temp) && map.get(temp) != null) {
            TreeNode node = map.get(temp);
            System.out.println(node.val);
            temp = node;
        }
    }

    private static void populateNode(TreeNode root, TreeNode parent, Map<TreeNode, TreeNode> map) {
        if(root == null)
            return;
        map.put(root, parent);
        populateNode(root.left, root, map);
        populateNode(root.right, root, map);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(10);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(15);
        root.right.left = new TreeNode(16);
        root.right.left.left = new TreeNode(17);

        path(root, root.right.left.left);

    }
}
