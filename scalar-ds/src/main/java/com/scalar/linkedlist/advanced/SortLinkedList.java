package com.scalar.linkedlist.advanced;

import com.scalar.common.ListNode;
import com.scalar.linkedlist.ListUtil;

/**
 * @author t0k02w6 on 01/06/22
 * @project scalar-ds
 */
public class SortLinkedList {
    private static ListNode sort(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode mid = findMid(head);
        ListNode midNext = mid.next;
        mid.next = null;
        head = sort(head);
        midNext = sort(midNext);
        return merge(head, midNext);
    }

    private static ListNode merge(ListNode a, ListNode b) {
        if(a == null)
            return b;
        if(b == null)
            return a;
        ListNode result;
        if(a.val < b.val) {
            result = a;
            result.next = merge(a.next, b);
        } else {
            result = b;
            result.next = merge(a, b.next);
        }
        return result;
    }

    private static ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(23);
        head.next = new ListNode(13);
        head.next.next = new ListNode(10);
        head.next.next.next = new ListNode(12);
        head.next.next.next.next = new ListNode(16);

        head = sort(head);

        ListUtil.printLL(head);
    }
}
