package com.scalar.ds.heaps.homework;

import com.scalar.ds.common.ListNode;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @author t0k02w6 on 12/07/22
 * @project scalar
 */
public class MergeKSortedList {
    static class PQItem implements Comparable<PQItem> {
        int aIndx;
        ListNode head;

        public PQItem(int aIndx, ListNode head) {
            this.aIndx = aIndx;
            this.head = head;
        }


        @Override
        public int compareTo(PQItem o) {
            return this.head.val - o.head.val;
        }
    }

    public ListNode mergeKLists(ArrayList<ListNode> a) {
        PriorityQueue<PQItem> pQ = new PriorityQueue<>();
        for(int i = 0; i < a.size(); i++) {
            PQItem pqItem = new PQItem(i, a.get(i));
            pQ.add(pqItem);
        }

        ListNode result = new ListNode(Integer.MAX_VALUE);
        ListNode temp = result;

        while(!pQ.isEmpty()) {
            PQItem pqItem = pQ.poll();
            ListNode newNode = new ListNode(pqItem.head.val);
            temp.next = newNode;
            temp = temp.next;
            if(pqItem.head.next != null)
                pQ.add(new PQItem(pqItem.aIndx, pqItem.head.next));
        }

        result = result.next;
        return result;
    }

    public static void main(String[] args) {

    }
}
