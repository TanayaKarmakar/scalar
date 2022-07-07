package com.scalar.ds.linkedlist.advanced.assignment;

import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 04/06/22
 * @project scalar
 */
public class CopyList {

    static class RandomListNode {
         int label;
         RandomListNode next, random;
         RandomListNode(int x) { this.label = x; }
    };

    private static RandomListNode copyRandomList(RandomListNode head) {
        if(head == null)
            return null;
        if(head.next == null)
            return new RandomListNode(head.label);
        Map<RandomListNode, RandomListNode> nodeMap = new HashMap<>();
        RandomListNode temp = head;
        while(temp != null) {
            RandomListNode newNode = new RandomListNode(temp.label);
            nodeMap.put(temp, newNode);
            temp = temp.next;
        }

        temp = head;
        while(temp != null) {
            RandomListNode randomNode = temp.random;
            RandomListNode nextNewNode = temp.next;
            RandomListNode newNode = nodeMap.get(temp);
            newNode.random = nodeMap.get(randomNode);
            newNode.next = nodeMap.get(nextNewNode);
            temp = temp.next;
        }
        return nodeMap.get(head);
    }

    public static void main(String[] args) {

    }
}
