package com.scalar.ds.linkedlist.advanced.homework;

import com.scalar.ds.common.ListNode;
import com.scalar.ds.linkedlist.ListUtil;

/**
 * @author t0k02w6 on 07/06/22
 * @project scalar
 */
public class ReverseInPairs {
    private static ListNode swapPairs(ListNode A) {
        if(A == null || A.next == null)
            return A;
        ListNode prev = null;
        ListNode curr = A;
        ListNode next = null;

        int count = 0;
        while(curr != null && count < 2) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        if(next != null)
            A.next = swapPairs(next);
        return prev;
    }

    public static void main(String[] args) {
        ListNode h1 = new ListNode(1);
        h1.next = new ListNode(2);
        h1.next.next = new ListNode(3);
        h1.next.next.next = new ListNode(4);

        h1 = swapPairs(h1);

        ListUtil.printLL(h1);
    }
}
