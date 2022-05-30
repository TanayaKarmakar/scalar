package com.scalar.linkedlist.advanced;

import com.scalar.common.ListNode;
import com.scalar.linkedlist.ListUtil;

/**
 * @author t0k02w6 on 27/05/22
 * @project scalar-ds
 */
public class InsertNodeAtKThIndex {
    private static ListNode insertAtKThPosition(ListNode head, int k, int value) {
        ListNode tmp = head;
        while(tmp != null && k > 1) {
            tmp = tmp.next;
            k--;
        }

        ListNode tmpNext = tmp.next;
        ListNode newNode = new ListNode(value);
        newNode.next = tmpNext;
        tmp.next = newNode;
        return head;
    }



    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(-5);
        head.next.next.next = new ListNode(17);
        head.next.next.next.next = new ListNode(6);

        head = insertAtKThPosition(head, 2, 20);
        ListUtil.printLL(head);
    }
}
