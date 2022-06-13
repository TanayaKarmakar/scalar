package com.scalar.linkedlist.advanced.assignment;

import com.scalar.common.ListNode;
import com.scalar.linkedlist.ListUtil;

/**
 * @author t0k02w6 on 30/05/22
 * @project scalar-ds
 */
public class ReverseListFromToPosition {
    private static ListNode reverseBetween(ListNode A, int B, int C) {
        if(B == C)
           return A;
        ListNode part1 = null;
        ListNode prev = null;
        ListNode curr = A;
        ListNode next = null;


        int count = 1;
        while(curr != null && count < B) {
            part1 = curr;
            curr = curr.next;
            count++;
        }

        int total = (B + C);
        prev = null;
        ListNode temp = curr;
        while(curr != null && count < (total - 1)) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        if(B == 1)
            A = prev;
        else
            part1.next = prev;
        temp.next = curr;
        return A;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
       // head.next.next.next = new ListNode(4);
       // head.next.next.next.next = new ListNode(5);

        int B = 1;
        int C = 2;

        head = reverseBetween(head, B, C);

        ListUtil.printLL(head);
    }
}
