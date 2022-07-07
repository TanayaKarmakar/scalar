package com.scalar.ds.linkedlist.advanced.homework;

import com.scalar.ds.common.ListNode;

/**
 * @author t0k02w6 on 02/06/22
 * @project scalar-ds
 */
public class SortList {
    private static ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
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

    private static ListNode sortList(ListNode A) {
        if(A == null || A.next == null)
            return A;
        ListNode mid = findMid(A);
        ListNode midNext = mid.next;
        mid.next = null;
        A = sortList(A);
        midNext = sortList(midNext);
        return merge(A, midNext);
    }

    public static void main(String[] args) {

    }
}
