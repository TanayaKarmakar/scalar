package com.scalar.ds.tree;

import com.scalar.ds.common.TreeNode;

/**
 * @author t0k02w6 on 27/02/22
 * @project scalar-ds
 */
public class SearchForAKey {
    private static boolean search(TreeNode root, int key) {
        if(root == null)
            return false;
        if(root.val == key)
            return true;
        boolean isFoundAtLeft = search(root.left, key);
        boolean isFoundAtRight = search(root.right, key);
        return isFoundAtLeft || isFoundAtRight;
    }

    public static void main(String[] args) {

    }
}
