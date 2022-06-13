package com.scalar.linkedlist.advanced.homework;


import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 07/06/22
 * @project scalar
 */
public class CloneALinkedList {
    static class ListNode {
        int val;
        ListNode next, random;
        ListNode(int x) {
            val = x;
            next = random = null;
        }
    }

    private static ListNode cloneList(ListNode A) {
        if(A == null)
            return null;
        if(A.next == null)
            return new ListNode(A.val);
        Map<ListNode, ListNode> map = new HashMap<>();

        ListNode temp = A;

        while(temp != null) {
            ListNode newNode = new ListNode(temp.val);
            map.put(temp, newNode);

            temp = temp.next;
        }


        temp = A;
        while(temp != null) {
            ListNode currNode = map.get(temp);
            currNode.next = map.get(temp.next);
            currNode.random = map.get(temp.random);

            temp = temp.next;
        }

        return map.get(A);
    }

    public static void main(String[] args) {

    }
}
