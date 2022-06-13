package com.scalar.linkedlist.advanced.assignment;

import com.scalar.common.ListNode;
import com.scalar.common.Pair;
import com.scalar.linkedlist.ListUtil;

/**
 * @author t0k02w6 on 30/05/22
 * @project scalar-ds
 */
public class DeleteMiddleNodeLinkedList {
    private static Pair<ListNode, ListNode> findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        ListNode midPrev = null;
        while(fast != null && fast.next != null) {
            midPrev = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        return new Pair<>(slow, midPrev);
    }

    private static ListNode solve(ListNode A) {
        if(A == null || A.next == null)
            return null;
        Pair<ListNode, ListNode> midPair = findMiddle(A);
        midPair.getSecond().next = midPair.getFirst().next;
        return A;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        head = solve(head);

        ListUtil.printLL(head);
    }
}
