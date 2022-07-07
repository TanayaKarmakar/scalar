package com.scalar.ds.linkedlist.advanced.assignment;

import com.scalar.ds.common.ListNode;

/**
 * @author t0k02w6 on 30/05/22
 * @project scalar-ds
 */
public class ReverseLinkedList {
    private static ListNode reverseList(ListNode A) {
        if(A == null || A.next == null)
            return A;
        ListNode prev = null;
        ListNode curr = A;
        ListNode next = null;

        while(curr != null) {
            next = curr.next;
            curr.next =  prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static void main(String[] args) {

    }
}
