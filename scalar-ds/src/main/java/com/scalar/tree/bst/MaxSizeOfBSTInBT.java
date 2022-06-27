package com.scalar.tree.bst;

import com.scalar.common.TreeNode;

/**
 * @author t0k02w6 on 26/06/22
 * @project scalar
 */
public class MaxSizeOfBSTInBT {
    static class Item {
        int min;
        int max;
        int size;
        boolean isBST;

        public Item(int min, int max, int size, boolean isBST) {
            this.min = min;
            this.max = max;
            this.size = size;
            this.isBST = isBST;
        }
    }

    private static int maxSize = 0;

    private static Item validBSTRec(TreeNode root) {
        if(root == null)
            return new Item(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, true);
        Item leftItem = validBSTRec(root.left);
        Item rightItem = validBSTRec(root.right);

        if(leftItem.isBST && rightItem.isBST && root.val >= leftItem.max && root.val < rightItem.min) {
            int minValue = Integer.min(leftItem.min, root.val);
            int maxValue = Integer.max(rightItem.max, root.val);
            int total = leftItem.size + rightItem.size + 1;
            if(total > maxSize) {
                maxSize = total;
            }
            return new Item(minValue, maxValue, total, true);
        }
        return new Item(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, false);
    }

    private static int solve(TreeNode root) {
        validBSTRec(root);
        return maxSize;
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(40);
        root.left = new TreeNode(30);
        root.right = new TreeNode(60);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(20);
        root.right.left = new TreeNode(45);
        root.right.right = new TreeNode(70);
        root.right.right.left = new TreeNode(65);
        root.right.right.right = new TreeNode(80);

        int ans = solve(root);
        System.out.println(ans);
    }
}
