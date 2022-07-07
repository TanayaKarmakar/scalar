package com.scalar.ds.tree.assignment;

import com.scalar.ds.common.TreeNode;

/**
 * @author t0k02w6 on 22/06/22
 * @project scalar
 */
public class ConstructTreeFromInorderPostorder {
    private static int postIndx = -1;

    private static TreeNode buildTree(int[] A, int[] B) {
        int n = A.length;
        postIndx = n - 1;
        TreeNode root = buildTreeRec(A, B, 0, n - 1);
        return root;
    }

    private static int findItem(int[] a, int el, int start, int end) {
        for(int i = start; i <= end; i++) {
            if(a[i] == el)
                return i;
        }
        return -1;
    }

    private static TreeNode buildTreeRec(int[] a, int[] b, int start, int end) {
        if(start > end)
            return null;
        int el = b[postIndx++];
        int indx = findItem(a, el, start, end);
        TreeNode root = new TreeNode(a[indx]);
        root.left = buildTreeRec(a, b, start, indx - 1);
        root.right = buildTreeRec(a, b, indx + 1, end);
        return root;
    }

    public static void main(String[] args) {

    }
}
