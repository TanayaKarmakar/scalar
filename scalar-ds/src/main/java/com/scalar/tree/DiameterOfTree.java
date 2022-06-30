package com.scalar.tree;

import com.scalar.common.TreeNode;

/**
 * @author t0k02w6 on 30/06/22
 * @project scalar
 */
public class DiameterOfTree {
    static class TreeInfo {
        int dia;
        int height;

        public TreeInfo(int dia, int height) {
            this.dia = dia;
            this.height = height;
        }
    }

    private static TreeInfo diaRec(TreeNode root) {
        if(root == null)
            return new TreeInfo(-1, -1);
        TreeInfo l = diaRec(root.left);
        TreeInfo r = diaRec(root.right);

        int height = 1 + Integer.max(l.height, r.height);
        int diameter = Integer.max(l.dia, Integer.max(r.dia, l.height + r.height + 2));
        return new TreeInfo(diameter, height);
    }

    private static int diameter(TreeNode root) {
        return diaRec(root).dia;
    }

    public static void main(String[] args) {

    }
}
