package com.scalar.ds.linkedlist.advanced.homework;

import com.scalar.ds.common.ListNode;

/**
 * @author t0k02w6 on 04/06/22
 * @project scalar
 */
public class PalindromeList {
    private static ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static ListNode reverse(ListNode head) {
        if(head == null || head.next == null)
            return head;
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

    private static int lPalin(ListNode A) {
        if(A == null || A.next == null)
            return 1;
        ListNode mid = findMid(A);
        ListNode midNext = mid.next;
        mid.next = null;
        midNext = reverse(midNext);

        ListNode t1 = A;
        ListNode t2 = midNext;
        while(t1 != null && t2 != null) {
            if(t1.val != t2.val)
                return 0;
            t1 = t1.next;
            t2 = t2.next;
        }

        if(t1 == null || t1.next == null)
            return 1;
        return 0;
    }

    public static void main(String[] args) {

    }
}
