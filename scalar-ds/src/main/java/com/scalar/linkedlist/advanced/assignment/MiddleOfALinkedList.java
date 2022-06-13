package com.scalar.linkedlist.advanced.assignment;

import com.scalar.common.ListNode;
import com.scalar.common.Pair;

/**
 * @author t0k02w6 on 30/05/22
 * @project scalar-ds
 */
public class MiddleOfALinkedList {
    private static int solve(ListNode A) {
        ListNode slow = A;
        ListNode fast = A;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.val;
    }

    public static void main(String[] args) {

    }
}
