package com.scalar.tree.bst.assignment;

import com.scalar.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author t0k02w6 on 26/06/22
 * @project scalar
 */
public class RecoverBinarySearchTree {
    private static void inorder(TreeNode root, List<Integer> inorderList) {
        if(root != null) {
            inorder(root.left, inorderList);
            inorderList.add(root.val);
            inorder(root.right, inorderList);
        }
    }

    private static int[] recoverTree(TreeNode A) {
        List<Integer> inorderList = new ArrayList<>();
        inorder(A, inorderList);
        List<Integer> temp = new ArrayList<>(inorderList);
        Collections.sort(temp);

        int[] res = new int[2];
        for(int i = 0; i < temp.size(); i++) {
            if(inorderList.get(i) != temp.get(i)) {
                int min = Integer.min(inorderList.get(i), temp.get(i));
                int max = Integer.max(inorderList.get(i), temp.get(i));
                res[0] = min;
                res[1] = max;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
