package com.scalar.ds.linkedlist.advanced;

import com.scalar.ds.common.ListNode;
import com.scalar.ds.linkedlist.ListUtil;

/**
 * @author t0k02w6 on 27/05/22
 * @project scalar-ds
 */
public class ReverseLinkedList {
    private static ListNode reverse(ListNode head) {
        if(head == null)
            return null;
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(8);
        head.next.next = new ListNode(14);
        head.next.next.next = new ListNode(20);
        head.next.next.next.next = new ListNode(24);
        head.next.next.next.next.next = new ListNode(29);
        head.next.next.next.next.next.next = new ListNode(40);
        head.next.next.next.next.next.next.next = new ListNode(45);

        head = reverse(head);
        ListUtil.printLL(head);
    }
}
