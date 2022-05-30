package com.scalar.linkedlist;

import com.scalar.common.ListNode;

/**
 * @author t0k02w6 on 27/05/22
 * @project scalar-ds
 */
public class ListUtil {
    public static void printLL(ListNode head) {
        ListNode tmp = head;

        while(tmp != null) {
            System.out.println(tmp.val);
            tmp = tmp.next;
        }
    }
}
