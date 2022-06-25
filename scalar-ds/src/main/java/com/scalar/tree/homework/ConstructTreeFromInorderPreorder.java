package com.scalar.tree.homework;

import com.scalar.common.TreeNode;

/**
 * @author t0k02w6 on 22/06/22
 * @project scalar
 */
public class ConstructTreeFromInorderPreorder {
    private static int preIndx = 0;

    private static TreeNode buildTree(int[] A, int[] B) {
        return buildTreeRec(A, B, 0, A.length - 1);
    }

    private static int searchItem(int[] in, int el, int start, int end) {
        for(int i = start; i <= end; i++) {
            if(in[i] == el)
                return i;
        }
        return -1;
    }

    private static TreeNode buildTreeRec(int[] a, int[] b, int start, int end) {
        if(start > end)
            return null;
        int el = a[preIndx++];
        int indx = searchItem(b, el, start, end);
        TreeNode root = new TreeNode(el);
        root.left = buildTreeRec(a, b, start, indx - 1);
        root.right = buildTreeRec(a, b, indx + 1, end);
        return root;
    }

    public static void main(String[] args) {

    }
}
