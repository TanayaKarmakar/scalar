package com.scalar.linkedlist.advanced.homework;

import com.scalar.common.ListNode;
import com.scalar.linkedlist.ListUtil;

/**
 * @author t0k02w6 on 02/06/22
 * @project scalar-ds
 */
public class MergeTwoSortedList {
    private static ListNode mergeTwoLists(ListNode A, ListNode B) {
        if(A == null)
            return B;
        if(B == null)
            return A;
        ListNode result;
        if(A.val < B.val) {
            result = A;
            result.next = mergeTwoLists(A.next, B);
        } else {
            result = B;
            result.next = mergeTwoLists(A, B.next);
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        l1.next = new ListNode(8);
        l1.next.next = new ListNode(20);

        ListNode l2 = new ListNode(4);
        l2.next = new ListNode(11);
        l2.next.next = new ListNode(15);

        ListNode result = mergeTwoLists(l1, l2);

        ListUtil.printLL(result);
    }
}
