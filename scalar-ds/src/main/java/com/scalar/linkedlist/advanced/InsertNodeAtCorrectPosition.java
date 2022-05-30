package com.scalar.linkedlist.advanced;

import com.scalar.common.ListNode;
import com.scalar.linkedlist.ListUtil;

/**
 * @author t0k02w6 on 27/05/22
 * @project scalar-ds
 */
public class InsertNodeAtCorrectPosition {

    private static ListNode insertAtCorrectPos(ListNode head, int item) {
        ListNode tmp = head;
        ListNode node = new ListNode(item);
        if(item < head.val) {
            node.next = head;
            head = node;
            return head;
        }

        while(tmp.next != null) {
            if(tmp.val < item && tmp.next.val >= item) {
                node.next = tmp.next;
                tmp.next = node;
                return head;
            }
            tmp = tmp.next;
        }
        tmp.next = node;
        return head;
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

        head = insertAtCorrectPos(head, 20);
        ListUtil.printLL(head);
    }
}
