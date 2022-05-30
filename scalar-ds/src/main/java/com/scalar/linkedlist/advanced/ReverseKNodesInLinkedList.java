package com.scalar.linkedlist.advanced;

import com.scalar.common.ListNode;
import com.scalar.linkedlist.ListUtil;


/**
 * @author t0k02w6 on 30/05/22
 * @project scalar-ds
 */
public class ReverseKNodesInLinkedList {
    private static ListNode reverseK(ListNode head, int k) {
        if(head == null || head.next == null)
            return head;
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        int count = 0;
        while(curr != null && count < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        head.next = curr;
        head = prev;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(6);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next = new ListNode(7);

        int k = 3;
        head = reverseK(head, k);
        ListUtil.printLL(head);
    }
}
