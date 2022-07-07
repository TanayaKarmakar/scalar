package com.scalar.ds.linkedlist.advanced;

import com.scalar.ds.common.MatrixNode;

/**
 * @author t0k02w6 on 01/06/22
 * @project scalar-ds
 */
public class Flatten2DLinkedListIntoSingleLinkedList {
    private static MatrixNode flatten(MatrixNode head) {
        return merge2DList(head);
    }

    private static MatrixNode findMid(MatrixNode head) {
        MatrixNode slow = head;
        MatrixNode fast = head;

        while(fast.down != null && fast.down.down != null) {
            slow = slow.down;
            fast = fast.down.down;
        }
        return slow;
    }

    private static MatrixNode merge(MatrixNode a, MatrixNode b) {
        if(a == null)
            return b;
        if(b == null)
            return a;
        MatrixNode result;
        if(a.val < b.val) {
            result = a;
            result.next = merge(a.next, b);
        } else {
            result = b;
            result.next = merge(a, b.next);
        }
        return result;
    }


    private static MatrixNode merge2DList(MatrixNode head) {
        if(head == null || head.down == null)
            return head;
        MatrixNode mid = findMid(head);
        MatrixNode midNext = mid.down;
        mid.down = null;
        head = merge2DList(head);
        midNext = merge2DList(midNext);
        return merge(head, midNext);
    }

    private static void printList(MatrixNode head) {
        MatrixNode temp = head;
        while(temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        MatrixNode row1 = new MatrixNode(3);
        row1.next = new MatrixNode(8);
        row1.next.next = new MatrixNode(10);
        row1.next.next.next = new MatrixNode(14);
        row1.next.next.next.next = new MatrixNode(21);

        MatrixNode row2 = new MatrixNode(2);
        row2.next = new MatrixNode(6);

        row1.down = row2;

        MatrixNode row3 = new MatrixNode(1);
        row3.next = new MatrixNode(4);
        row3.next.next = new MatrixNode(5);
        row2.down = row3;

        MatrixNode row4 = new MatrixNode(7);
        row4.next = new MatrixNode(9);
        row4.next.next = new MatrixNode(11);
        row4.next.next.next = new MatrixNode(13);
        row3.down = row4;

        row1 = flatten(row1);
        printList(row1);
    }
}
