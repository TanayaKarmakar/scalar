package com.scalar.ds.linkedlist.advanced.assignment;

import com.scalar.ds.common.ListNode;
import com.scalar.ds.linkedlist.ListUtil;

/**
 * @author t0k02w6 on 30/05/22
 * @project scalar-ds
 */
public class ReverseListFromToPosition {
    private static ListNode reverseBetween(ListNode A, int B, int C) {
        if(A == null || A.next == null)
            return A;

        ListNode prev = null;
        ListNode curr = A;
        ListNode part1 = null;
        ListNode next = null;

        int count = 1;

        while(curr != null && count < B) {
            part1 = curr;
            curr = curr.next;
            count++;
        }


        while(curr != null && count < C) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }


        return A;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int B = 1;
        int C = 2;

        head = reverseBetween(head, B, C);

        ListUtil.printLL(head);
    }
}
