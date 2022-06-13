package com.scalar.linkedlist.advanced.assignment;

import com.scalar.common.ListNode;

/**
 * @author t0k02w6 on 02/06/22
 * @project scalar-ds
 */
public class DetectCycle {
    private static ListNode detectCycle(ListNode a) {
        ListNode slow = a;
        ListNode fast = a;

        do {
            slow = slow.next;
            fast = fast.next.next;
        } while(fast != null  && fast.next != null && slow != fast);

        if(slow != fast)
            return null;
        slow = a;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(87797);
        head.next = new ListNode(23219);
        head.next.next = new ListNode(41441);
        head.next.next.next = new ListNode(58396);
        head.next.next.next.next = new ListNode(48953);
        head.next.next.next.next.next = new ListNode(94603);
        head.next.next.next.next.next.next = new ListNode(2721);
        head.next.next.next.next.next.next.next = new ListNode(95832);
        head.next.next.next.next.next.next.next.next = new ListNode(49029);
        head.next.next.next.next.next.next.next.next.next = new ListNode(98448);
        head.next.next.next.next.next.next.next.next.next.next = new ListNode(65450);

        ListNode ans = detectCycle(head);

        System.out.println(ans);
    }
}
