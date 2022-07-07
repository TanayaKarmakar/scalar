package com.scalar.ds.linkedlist.advanced.homework;

import com.scalar.ds.common.ListNode;
import com.scalar.ds.linkedlist.ListUtil;

/**
 * @author t0k02w6 on 30/05/22
 * @project scalar-ds
 */
public class RemoveDuplicates {
    private static ListNode deleteDuplicates(ListNode A) {
        if(A == null || A.next == null)
            return A;
        ListNode p = A;
        while(p != null) {
            ListNode q = p.next;
            while(q != null && p.val == q.val)
                q = q.next;

            p.next = q;
            p = q;
        }
        return A;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);

        head = deleteDuplicates(head);

        ListUtil.printLL(head);
    }
}
