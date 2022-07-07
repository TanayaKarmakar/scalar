package com.scalar.ds.linkedlist.advanced;

import com.scalar.ds.common.ListNode;

/**
 * @author t0k02w6 on 27/05/22
 * @project scalar-ds
 */
public class LengthOfLinkedList {
    private static int len(ListNode head) {
        ListNode tmp = head;

        int count = 0;
        while(tmp != null) {
            count++;
            tmp = tmp.next;
        }
        return count;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        int ans = len(head);

        System.out.println("Length - " + ans);
    }
}
