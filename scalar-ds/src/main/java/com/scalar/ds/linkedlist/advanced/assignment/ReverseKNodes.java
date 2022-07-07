package com.scalar.ds.linkedlist.advanced.assignment;

import com.scalar.ds.common.ListNode;

/**
 * @author t0k02w6 on 30/05/22
 * @project scalar-ds
 */
public class ReverseKNodes {
    private static ListNode reverseList(ListNode A, int B) {
        if(A == null || A.next == null)
            return A;
        ListNode prev = null;
        ListNode curr = A;
        ListNode next = null;
        int count = 0;
        while(count < B && curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        if(next != null)
            A.next = reverseList(next, B);
        return prev;
    }

    public static void main(String[] args) {

    }
}
