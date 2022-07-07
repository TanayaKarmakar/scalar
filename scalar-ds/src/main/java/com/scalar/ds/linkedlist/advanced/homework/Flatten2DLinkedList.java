package com.scalar.ds.linkedlist.advanced.homework;

import com.scalar.ds.common.MatrixNode;

/**
 * @author t0k02w6 on 12/06/22
 * @project scalar
 */
public class Flatten2DLinkedList {
    static class ListNode {
        public int val;
        public ListNode right;
        public ListNode down;

        public ListNode(int val) {
            this.val = val;
        }
    }

    private static ListNode findMid(ListNode head) {
        if(head == null || head.right == null)
            return head;
        ListNode fast = head;
        ListNode slow = head;

        while(fast.right != null && fast.right.right != null) {
            slow = slow.right;
            fast = fast.right.right;
        }
        return slow;
    }

    private static ListNode flatten(ListNode root) {
        if(root == null || root.right == null)
            return root;
        ListNode mid = findMid(root);
        ListNode midNext = mid.right;
        mid.right = null;
        root = flatten(root);
        midNext = flatten(midNext);
        return merge(root, midNext);
    }

    private static ListNode merge(ListNode a, ListNode b) {
        if(a == null)
            return b;
        if(b == null)
            return a;
        ListNode result;
        if(a.val < b.val) {
            result = a;
            result.down = merge(a.down, b);
        } else {
            result = b;
            result.down = merge(a, b.down);
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
