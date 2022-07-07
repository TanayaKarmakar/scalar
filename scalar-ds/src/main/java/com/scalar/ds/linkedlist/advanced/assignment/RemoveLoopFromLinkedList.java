package com.scalar.ds.linkedlist.advanced.assignment;

import com.scalar.ds.common.ListNode;

/**
 * @author t0k02w6 on 02/06/22
 * @project scalar-ds
 */
public class RemoveLoopFromLinkedList {
    private static ListNode solve(ListNode A) {
        if(A == null || A.next == null)
            return A;
        ListNode slow = A;
        ListNode fast = A;

        do {
            slow = slow.next;
            fast = fast.next.next;
        } while(fast != null  && fast.next != null && slow != fast);

        if(slow != fast)
            return A;
        slow = A;
        ListNode fastPrev = fast;
        while(slow != fast) {
            fastPrev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        fastPrev.next = null;
        return A;
    }

    public static void main(String[] args) {

    }
}
