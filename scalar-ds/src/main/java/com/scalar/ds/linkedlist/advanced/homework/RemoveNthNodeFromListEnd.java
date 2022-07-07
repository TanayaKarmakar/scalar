package com.scalar.ds.linkedlist.advanced.homework;

import com.scalar.ds.common.ListNode;
import com.scalar.ds.linkedlist.ListUtil;

/**
 * @author t0k02w6 on 30/05/22
 * @project scalar-ds
 */
public class RemoveNthNodeFromListEnd {
    private static ListNode removeNthFromEnd(ListNode A, int B) {
        ListNode fast = A;
        int count = 0;
        while(fast != null && count < B) {
            fast = fast.next;
            count++;
        }

        ListNode slow = A;
        ListNode slowPrev = A;
        while(fast != null) {
            slowPrev = slow;
            slow = slow.next;
            fast = fast.next;
        }

        if(slow == A) {
            slow = slow.next;
            return slow;
        } else {
            slowPrev.next = slow.next;
        }
        return A;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        int B = 1;

        a = removeNthFromEnd(a, B);

        ListUtil.printLL(a);
    }
}
