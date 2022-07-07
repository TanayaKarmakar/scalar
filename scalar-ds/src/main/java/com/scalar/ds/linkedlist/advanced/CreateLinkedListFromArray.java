package com.scalar.ds.linkedlist.advanced;

import com.scalar.ds.common.ListNode;
import com.scalar.ds.linkedlist.ListUtil;

/**
 * @author t0k02w6 on 27/05/22
 * @project scalar-ds
 */
public class CreateLinkedListFromArray {
    public static void main(String[] args) {
        int[] arr = {2,4,6,8,10};
        ListNode head = createLL(arr);
        ListUtil.printLL(head);
    }


    private static ListNode createLL(int[] arr) {
        ListNode head = null;
        ListNode tmp = head;
        for(int i = 0; i < arr.length; i++) {
            if(tmp == null) {
                tmp = new ListNode(arr[i]);
                head = tmp;
            } else {
                tmp.next = new ListNode(arr[i]);
                tmp = tmp.next;
            }
        }
        return head;
    }
}
