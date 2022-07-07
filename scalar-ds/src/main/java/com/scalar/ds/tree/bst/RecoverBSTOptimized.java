package com.scalar.ds.tree.bst;

import com.scalar.ds.common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author t0k02w6 on 27/06/22
 * @project scalar
 */
public class RecoverBSTOptimized {
    private static void inorder(TreeNode root, List<Integer> result) {
        if(root != null) {
            inorder(root.left, result);
            result.add(root.val);
            inorder(root.right, result);
        }
    }

    private static int[] recoverTree(TreeNode root) {
        List<Integer> inorderList = new ArrayList<>();
        inorder(root, inorderList);

        int dipCount = 0;
        int indx1 = -1;
        int indx2 = -1;
        int i = 0;
        for(i = 1; i < inorderList.size(); i++) {
            if(inorderList.get(i) < inorderList.get(i - 1)) {
                dipCount++;
                indx1 = (i - 1);
                break;
            }
        }

        for(int j = i; j < inorderList.size(); j++) {
            if(inorderList.get(i) < inorderList.get(i - 1)){
                dipCount++;
                indx2 = i;
                break;
            }
        }

        if(dipCount == 1) {
            indx2 = (i - 1);
            indx1 = i;
        }
        return new int[] {inorderList.get(indx1), inorderList.get(indx2)};
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(15);
        root.left = new TreeNode(10);
        root.right = new TreeNode(13);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(24);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(8);
        root.left.right.left = new TreeNode(11);
        root.right.left = new TreeNode(18);
        root.right.right = new TreeNode(35);
        root.right.left.left = new TreeNode(16);
        root.right.left.right = new TreeNode(20);
        root.right.left.right.right = new TreeNode(22);

        int[] ans = recoverTree(root);
        System.out.println(Arrays.toString(ans));
    }
}
