package com.scalar.linkedlist.advanced.homework;

import com.scalar.common.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author t0k02w6 on 07/06/22
 * @project scalar
 */
public class MergeKSortedList {
    static class ListItem implements Comparable<ListItem> {
        ListNode node;
        int aValue;

        public ListItem(ListNode node, int aValue) {
            this.node = node;
            this.aValue = aValue;
        }

        @Override
        public int compareTo(ListItem o) {
            if(this.node.val == o.node.val)
                return this.aValue - o.aValue;
            return this.node.val - o.node.val;
        }
    }

    private static ListNode mergeKLists(ArrayList<ListNode> a) {
        PriorityQueue<ListItem> pQ = new PriorityQueue<>();
        ListNode result = new ListNode(Integer.MAX_VALUE);
        ListNode temp = result;
        for(int i = 0; i < a.size(); i++) {
            pQ.add(new ListItem(a.get(i), i));
        }

        while(!pQ.isEmpty()) {
            ListItem item = pQ.poll();
            temp.next = item.node;
            temp = temp.next;
            if(item.node.next != null)
                pQ.add(new ListItem(item.node.next, item.aValue));
        }

        result = result.next;
        return result;
    }

    public static void main(String[] args) {

    }
}
