package com.scalar.ds.linkedlist.advanced.assignment;

import com.scalar.ds.common.ListNode;
import com.scalar.ds.linkedlist.ListUtil;

/**
 * @author t0k02w6 on 02/06/22
 * @project scalar-ds
 */
public class ReorderList {
    private static ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        ListNode next;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    private static ListNode reorderList(ListNode A) {
        if(A == null || A.next == null)
            return A;
        ListNode mid = findMid(A);
        ListNode midNext = mid.next;
        mid.next = null;
        midNext = reverseList(midNext);

        ListNode t1 = A;
        ListNode t2 = midNext;

        ListNode result = new ListNode(Integer.MAX_VALUE);
        ListNode t3 = result;

        while(t1 != null && t2 != null) {
            ListNode curr = new ListNode(t1.val);
            t3.next = curr;
            t3 = t3.next;
            curr = new ListNode(t2.val);
            t3.next = curr;
            t3 = t3.next;
            t1 = t1.next;
            t2 = t2.next;
        }
        if(t1 != null)
            t3.next = new ListNode(t1.val);
        result = result.next;
        return result;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        head = reorderList(head);

        ListUtil.printLL(head);
    }
}
